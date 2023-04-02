package reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import enums.LogType;
import ultis.ScreenShotUltis;

import java.util.EnumMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public final class FrameworkLogger {

    private FrameworkLogger(){}

    private static BiConsumer<String,Media> PASS = (m,c) -> ReportManager.getTest().pass(m,c);

    private static BiConsumer<String,Media> FAIL = (m,c) -> ReportManager.getTest().fail(m,c);
    private static BiConsumer<String,Media> SKIP = (m,c) -> ReportManager.getTest().skip(m,c);
    private static BiConsumer<String,Media> INFO = (m,c) -> ReportManager.getTest().info(m,c);
    private static BiConsumer<String,Media> CONSOLE = (m,c) -> System.out.println("INFO ---------> "+ m);
    private static BiConsumer<String,Media> PASSANDCONSOLE = PASS.andThen(CONSOLE);
    private static BiConsumer<String,Media> INFOANDCONSOLE = INFO.andThen(CONSOLE);

    private static EnumMap<LogType,BiConsumer<String,Media>> MAP = new EnumMap<>(LogType.class);

    static {
        MAP.put(LogType.PASS,PASS);
        MAP.put(LogType.FAIL,FAIL);
        MAP.put(LogType.SKIP,SKIP);
        MAP.put(LogType.INFO,INFO);
        MAP.put(LogType.CONSOLE,CONSOLE);
        MAP.put(LogType.PASSANDCONSOLE,PASSANDCONSOLE);
        MAP.put(LogType.INFOANDCONSOLE,INFOANDCONSOLE);
    }

    public static void log(LogType type, String message, Media c){
        MAP.get(type).accept(message,c);
    }

}
