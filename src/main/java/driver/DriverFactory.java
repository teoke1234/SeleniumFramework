package driver;

import config.ConfigFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    DriverFactory() {
    }

    public static WebDriver getDriver(String browsername , String version) throws MalformedURLException {
        WebDriver driver = null;
        if (ConfigFactory.getConfig().runmode().equalsIgnoreCase("remote")) {

            driver = RemoteDriverFactory.getRemoteDriver(browsername, version);

        } else if (ConfigFactory.getConfig().runmode().equalsIgnoreCase("local")) {

            driver = LocalDriverFactory.getLocalDriver(browsername);
        }
        // throw exception when runmote property is null
        return driver;
    }
}
