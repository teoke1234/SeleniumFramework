package driver;

import config.ConfigFactory;
import config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {

    private Driver() {
    }

    public static void initDriver(String browser, String version) {
        if(Objects.isNull(DriverManager.getDriver()))
        {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser, version));
            } catch (MalformedURLException e) {
                e.getStackTrace();
            }

            DriverManager.getDriver().get(ConfigFactory.getConfig().url());
        }
    }

    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver()))
        {
            DriverManager.getDriver().quit();
            DriverManager.flushDriver();
        }

    }


}
