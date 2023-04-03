package driver;

import config.ConfigFactory;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    DriverFactory() {
    }

    public static WebDriver getDriver(String browsername , String version) throws MalformedURLException {
        WebDriver driver = null;
        if (ConfigFactory.getConfig().runmode().equalsIgnoreCase("remote")) {

            driver = RemoteDriverFactory.get(browsername, version);

        } else if (ConfigFactory.getConfig().runmode().equalsIgnoreCase("local")) {

            driver = LocalDriverFactory.get(browsername);
        }
        // throw exception when runmote property is null
        return driver;
    }
}
