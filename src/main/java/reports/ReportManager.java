package reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

public final class ReportManager {

    private ReportManager(){}

    private static final ThreadLocal<ExtentTest> TEST_THREAD_LOCAL = new ThreadLocal<>();

    static void setTest(ExtentTest testReport){
        if (Objects.nonNull(testReport)) {
        TEST_THREAD_LOCAL.set(testReport);
        }
    }

    static ExtentTest getTest(){
        return TEST_THREAD_LOCAL.get();
    }

    static void unload(){
        TEST_THREAD_LOCAL.remove();
    }
}
