package driver;

import config.ConfigFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public final class RemoteDriverFactory {
    private RemoteDriverFactory(){}

    static WebDriver getRemoteDriver(String browserName, String version) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browserName.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");

        } else if (browserName.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("edge");

        } else if (browserName.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");

        }
        capabilities.setVersion(version);

        return new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()),capabilities);
    }


}
