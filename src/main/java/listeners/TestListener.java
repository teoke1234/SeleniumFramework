package listeners;

import annotations.FrameworkAnnotations;
import enums.LogType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.FrameworkLogger;
import reports.Reports;

import java.util.Arrays;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reports.createTestReport(result.getMethod().getTestClass().getRealClass().getSimpleName()+
                " - "+ result.getName());
        Reports.assignAuthor(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).author());
        Reports.assignCategory(result.getMethod().getConstructorOrMethod().getMethod()
                .getAnnotation(FrameworkAnnotations.class).category());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        FrameworkLogger.log(LogType.PASSLASTRESULT,"Test Case : " + result.getName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        FrameworkLogger.log(LogType.FAILLASTRESULT,"Test Case : " + result.getName() + " is failed");
        FrameworkLogger.log(LogType.INFO,result.getThrowable().toString() );
        FrameworkLogger.log(LogType.INFO,Arrays.deepToString(result.getThrowable().getStackTrace()));


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        FrameworkLogger.log(LogType.SKIPLASTRESULT,"Test Case : " + result.getName() + " is skipped");
        FrameworkLogger.log(LogType.INFO,result.getThrowable().toString() );
        FrameworkLogger.log(LogType.INFO,Arrays.deepToString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    @Override
    public void onStart(ITestContext context) {
        Reports.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        Reports.flushReport();
    }
}
