//package reports;
//
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import ultis.ScreenShotUltis;
//
//public final class ReportLogs {
//
//    private ReportLogs(){}
//
//    public static void pass(String message){
//        ReportManager.getTest().pass(message,MediaEntityBuilder
//                .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build());
//    }
//
//    public static void fail(String message){
//        ReportManager.getTest().fail(message,MediaEntityBuilder
//                .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build());
//    }
//
//    public static void log(String message, Status status){
//        ReportManager.getTest().log(status,message);
//    }
//
//    public static void info(String message){
//        ReportManager.getTest().info(message,MediaEntityBuilder
//                .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build());
//    }
//
//    public static void skip(String message){
//        ReportManager.getTest().skip(message,MediaEntityBuilder
//                .createScreenCaptureFromBase64String(ScreenShotUltis.getScreenShoot()).build());
//    }
//
//
//}
