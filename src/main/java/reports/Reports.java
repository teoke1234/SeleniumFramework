package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.FrameworkConstants;
import enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class Reports {

    private Reports() {
    }

    private static ExtentReports reports;

    public static void initReport() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getReportPath());
        reports.attachReporter(spark);
    }

    public static void flushReport() {
        if(Objects.nonNull(reports)){
            reports.flush();
        }
        ReportManager.unload();
        try{
            Desktop.getDesktop().browse(new File(FrameworkConstants.getReportPath()).toURI());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void createTestReport(String testCaseName) {
        ReportManager.setTest(reports.createTest(testCaseName));
    }

    public static void assignAuthor(String[] authorNames){
        for (String authorName: authorNames) {
            ReportManager.getTest().assignAuthor(authorName);
        }
    }

    public static void assignCategory(CategoryType[] categoryTypes){
        for (CategoryType categoryType: categoryTypes) {
            ReportManager.getTest().assignCategory(categoryType.name().toString());
        }
    }

}
