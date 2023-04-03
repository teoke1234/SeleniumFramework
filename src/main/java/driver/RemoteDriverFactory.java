package driver;

import config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class RemoteDriverFactory {
    private RemoteDriverFactory() {
    }

    private static Consumer<DesiredCapabilities> CHROME = cap ->  cap.setBrowserName(BrowserType.CHROME);
    private static Consumer<DesiredCapabilities> EDGE = cap ->  cap.setBrowserName(BrowserType.EDGE);
    private static Consumer<DesiredCapabilities> FIREFOX = cap ->  cap.setBrowserName(BrowserType.FIREFOX);

    static Map<String,Consumer<DesiredCapabilities>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",CHROME);
        MAP.put("edge",EDGE);
        MAP.put("firefox",FIREFOX);
    }

    public static WebDriver get(String browserName, String version) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        MAP.get(browserName.toLowerCase()).accept(capabilities);
        capabilities.setVersion(version);
        return new RemoteWebDriver(new URL(ConfigFactory.getConfig().remoteurl()), capabilities);
    }

}
