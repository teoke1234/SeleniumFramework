package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public final class LocalDriverFactory {
    private LocalDriverFactory() {
    }

    private static Supplier<WebDriver> CHROME = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };

    private static Supplier<WebDriver> EDGE = () -> {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    };

    private static Supplier<WebDriver> FIREFOX = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };

    static Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",CHROME);
        MAP.put("edge",EDGE);
        MAP.put("firefox",FIREFOX);
    }

    public static WebDriver get(String browserName){
        return MAP.get(browserName.toLowerCase()).get();
    }

}
