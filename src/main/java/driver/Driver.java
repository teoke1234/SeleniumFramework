package driver;

import config.ConfigFactory;
import config.FrameworkConfig;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if(Objects.isNull(DriverManager.getDriver()))
        {
            WebDriver driver = DriverFactory.getDriver(ConfigFactory.getConfig().browser());
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
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
