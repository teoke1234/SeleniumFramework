package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import config.ConfigFactory;
import enums.LogType;
import ultis.ScreenShotUltis;

import java.util.EnumMap;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger() {
    }

    private static final Consumer<String> PASS = m -> ReportManager.getTest().pass(m);

    private static final Consumer<String> FAIL = m -> ReportManager.getTest().fail(m);
    private static final Consumer<String> SKIP = m -> ReportManager.getTest().skip(m);
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
        PASSSTEPSSCREENSHOT.put(LogType.PASS, PASS.andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT).andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.SKIP, SKIP.andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.INFO, INFO.andThen(CONSOLE));
        PASSSTEPSSCREENSHOT.put(LogType.CONSOLE, CONSOLE);
        PASSSTEPSSCREENSHOT.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
        SCREENSHOTMAP.put(LogType.PASS, PASS.andThen(TAKESCREENSHOT).andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.FAIL, FAIL.andThen(TAKESCREENSHOT).andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.SKIP, SKIP.andThen(TAKESCREENSHOT).andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.INFO, INFO.andThen(CONSOLE));
        SCREENSHOTMAP.put(LogType.CONSOLE, CONSOLE);
        SCREENSHOTMAP.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE.andThen(TAKESCREENSHOT));

    }

    public static void log(LogType type, String message) {
        if (ConfigFactory.getConfig().passStepsScreenshot().equalsIgnoreCase("yes")) {
            PASSSTEPSSCREENSHOT.getOrDefault(type, EXTENTANDCONSOLE).accept(message);
        } else {
            SCREENSHOTMAP.getOrDefault(type, EXTENTANDCONSOLE).accept(message);
        }
    }

}
