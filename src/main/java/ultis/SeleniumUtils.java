package ultis;

import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import reports.ReportLogs;
import reports.Reports;

public final class SeleniumUtils {

    private SeleniumUtils(){}

    public static void click(By by, String element) {
        DriverManager.getDriver().findElement(by).click();
        ReportLogs.pass(element +" is clicked");
    }

    public static void click(By by, WaitStrategy waitStrategy,String element){
        WaitFactory.waitForElement(waitStrategy,by).click();
        ReportLogs.pass(element +" is clicked");
    }

    public static void sendKeys(By by, String keys, WaitStrategy waitStrategy, String element) {
        WaitFactory.waitForElement(waitStrategy,by).sendKeys(keys);
        ReportLogs.pass("Sends keys to "+ element);
    }
    public static void sendKeys(By by, String keys, String element) {
        DriverManager.getDriver().findElement(by).sendKeys(keys);
        ReportLogs.pass("Sends keys to "+ element);
    }




}
