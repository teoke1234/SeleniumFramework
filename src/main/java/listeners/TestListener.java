package listeners;

import annotations.FrameworkAnnotations;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ReportLogs;
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
        ReportLogs.pass("Test Case : " + result.getName() + " is pass");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportLogs.fail("Test Case : " + result.getName() + " is failed");
        ReportLogs.log(result.getThrowable().toString(), Status.FAIL);
        ReportLogs.log(Arrays.deepToString(result.getThrowable().getStackTrace()), Status.FAIL);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportLogs.skip("Test Case : "+ result.getName() +" is skipped");
        ReportLogs.log(result.getThrowable().toString(), Status.SKIP);
        ReportLogs.log(Arrays.deepToString(result.getThrowable().getStackTrace()), Status.SKIP);
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
