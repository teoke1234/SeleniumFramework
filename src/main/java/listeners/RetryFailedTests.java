//package listeners;
//
//import config.ConfigFactory;
//import org.testng.IRetryAnalyzer;
//import org.testng.ITestResult;
//
//public class RetryFailedTests implements IRetryAnalyzer {
//
//    private int count = 0;
//    private int times = 1;
//
//    @Override
//    public boolean retry(ITestResult iTestResult) {
//        boolean retry = false;
//        if(ConfigFactory.getConfig().retryfailedtestcases().equalsIgnoreCase("yes")){
//            retry = count<times;
//            count++;
//
//        }
//        return retry;
//    }
//}
