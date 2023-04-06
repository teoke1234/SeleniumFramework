package constants;


import lombok.Getter;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final String REPORT_FILE = "/index.html";
    private static final String EXCEL_FILE_PATH = PROJECT_PATH + "\\src\\test\\resources\\Book1.xlsx";
    private static final String RUNMANGERSHEET = "RUNMANAGER";
    public static String getReportPath() {
        return PROJECT_PATH + REPORT_FILE;
    }
    public static String getExcelFilePath(){return EXCEL_FILE_PATH;}
    public static String getRunmangersheet(){return RUNMANGERSHEET;}
}
