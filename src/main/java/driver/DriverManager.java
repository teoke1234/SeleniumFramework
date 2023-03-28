package driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class DriverManager {

    private DriverManager() {
    }

    private static final ThreadLocal<WebDriver> THREAD_DRIVER = new ThreadLocal<>();

    static void setDriver(WebDriver driver) {
        if (Objects.nonNull(driver)) {
            THREAD_DRIVER.set(driver);
        }
    }

    public static WebDriver getDriver() {
        return THREAD_DRIVER.get();
    }

    static void flushDriver(){
        THREAD_DRIVER.remove();
    }


}
