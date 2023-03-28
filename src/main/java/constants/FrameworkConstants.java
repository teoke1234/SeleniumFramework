package constants;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String REPORT_FILE = "/index.html";

    public static String getReportPath() {
        return PROJECT_PATH + REPORT_FILE;
    }

}
