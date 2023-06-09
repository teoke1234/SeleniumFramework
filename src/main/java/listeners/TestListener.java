package listeners;

import annotations.FrameworkAnnotations;
import enums.LogType;
import org.testng.*;
import reports.FrameworkLogger;
import reports.Reports;

import java.util.Arrays;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        Reports.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        Reports.flushReport();
    }

    @Override
    public void onTestStart(ITestResult result) {
        Reports.createTestReport(result.getName() +
                " - " + result.getMethod().getTestClass().getRealClass().getSimpleName());
        Reports.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).author());
        Reports.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        FrameworkLogger.log(LogType.PASSLASTRESULT, "Test Case : " + result.getName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        FrameworkLogger.log(LogType.FAILLASTRESULT, "Test Case : " + result.getName() + " is failed");
        FrameworkLogger.log(LogType.FAIL, result.getThrowable().toString());
        FrameworkLogger.log(LogType.FAIL, Arrays.deepToString(result.getThrowable().getStackTrace()));

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        FrameworkLogger.log(LogType.SKIPLASTRESULT, "Test Case : " + result.getName() + " is skipped");
        FrameworkLogger.log(LogType.INFO, result.getThrowable().toString());
        FrameworkLogger.log(LogType.INFO, Arrays.deepToString(result.getThrowable().getStackTrace()));
    }




}
