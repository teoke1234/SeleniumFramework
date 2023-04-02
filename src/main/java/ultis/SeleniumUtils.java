package ultis;

import com.aventstack.extentreports.MediaEntityBuilder;
import config.ConfigFactory;
import driver.DriverManager;
import enums.LogType;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import static reports.FrameworkLogger.log;

public final class SeleniumUtils {

    private SeleniumUtils() {
    }

    public static void click(By by, String element) {
        DriverManager.getDriver().findElement(by).click();
        log(LogType.PASSANDCONSOLE, element + " is clicked", ScreenShotUltis.getBase64Media());
    }

    public static void click(By by, WaitStrategy waitStrategy, String element) {
        WaitFactory.waitForElement(waitStrategy, by).click();
        log(LogType.PASSANDCONSOLE, element + " is clicked", ScreenShotUltis.getBase64Media());
    }

    public static void sendKeys(By by, String keys, WaitStrategy waitStrategy, String element) {
        WaitFactory.waitForElement(waitStrategy, by).sendKeys(keys);
        log(LogType.PASSANDCONSOLE, "Sends keys " + "\"" + keys + "\"" + " to " + element,ScreenShotUltis.getBase64Media());
    }

    public static void sendKeys(By by, String keys, String element) {
        DriverManager.getDriver().findElement(by).sendKeys(keys);
        log(LogType.PASSANDCONSOLE, "Sends keys " + "\"" + keys + "\"" + " to " + element,ScreenShotUltis.getBase64Media());
    }

    public static void get(String url) {
        DriverManager.getDriver().get(url);
        log(LogType.PASSANDCONSOLE, "Access to URL : " + "\"" + url + "\"",ScreenShotUltis.getBase64Media());
    }




}
