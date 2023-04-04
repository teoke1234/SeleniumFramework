package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import config.ConfigFactory;
import enums.LogType;
import ultis.ScreenShotUltis;

import java.util.EnumMap;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = m -> ReportManager.getTest().pass(m);
    private static final Consumer<String> PASSLASTRESULT = m -> ReportManager.getTest().pass(MarkupHelper.createLabel(m, ExtentColor.GREEN));
    private static final Consumer<String> FAIL = m -> ReportManager.getTest().fail(m);
    private static final Consumer<String> FAILLASTRESULT = m -> ReportManager.getTest().fail(MarkupHelper.createLabel(m, ExtentColor.RED));
    private static final Consumer<String> SKIP = m -> ReportManager.getTest().skip(m);
    private static final Consumer<String> SKIPLASTRESULT = m -> ReportManager.getTest().skip(MarkupHelper.createLabel(m, ExtentColor.ORANGE));
    private static final Consumer<String> INFO = m -> ReportManager.getTest().info(m);
    private static final Consumer<String> CONSOLE = m -> System.out.println("INFO ---------> " + m);
    private static final Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);
    private static final Consumer<String> TAKESCREENSHOT = message -> ReportManager.getTest().info(
            "Screenshot is captured",
            MediaEntityBuilder
                    .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build());

    private static final EnumMap<LogType, Consumer<String>> PASSSTEPSSCREENSHOT = new EnumMap<>(LogType.class);
    private static final EnumMap<LogType, Consumer<String>> SCREENSHOTMAP = new EnumMap<>(LogType.class);

    static {
        PASSSTEPSSCREENSHOT.put(LogType.PASS, PASS.andThen(CONSOLE).andThen(TAKESCREENSHOT));
        PASSSTEPSSCREENSHOT.put(LogType.FAIL, FAIL.andThen(CONSOLE).andThen(TAKESCREENSHOT));
        PASSSTEPSSCREENSHOT.put(LogType.SKIP, SKIP.andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.INFO, INFO.andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.CONSOLE, CONSOLE);
        PASSSTEPSSCREENSHOT.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
        PASSSTEPSSCREENSHOT.put(LogType.PASSLASTRESULT, PASSLASTRESULT.andThen(TAKESCREENSHOT));
        PASSSTEPSSCREENSHOT.put(LogType.FAILLASTRESULT, FAILLASTRESULT.andThen(TAKESCREENSHOT));
        PASSSTEPSSCREENSHOT.put(LogType.SKIPLASTRESULT, SKIPLASTRESULT);

        SCREENSHOTMAP.put(LogType.PASS, PASS.andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT).andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.SKIP, SKIP.andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.INFO, INFO.andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.CONSOLE, CONSOLE);
        SCREENSHOTMAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE.andThen(TAKESCREENSHOT));
        SCREENSHOTMAP.put(LogType.PASSLASTRESULT, PASSLASTRESULT.andThen(TAKESCREENSHOT));
        SCREENSHOTMAP.put(LogType.FAILLASTRESULT, FAILLASTRESULT);
        SCREENSHOTMAP.put(LogType.SKIPLASTRESULT, SKIPLASTRESULT);

    }

    public static void log(LogType type, String message) {
        if (ConfigFactory.getConfig().passStepsScreenshot().equalsIgnoreCase("yes")) {
            PASSSTEPSSCREENSHOT.get(type).accept(message);
        } else {
            SCREENSHOTMAP.get(type).accept(message);
        }
    }

}
