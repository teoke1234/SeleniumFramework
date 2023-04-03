package ultis;

import config.ConfigFactory;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;


public final class WaitFactory {

    private WaitFactory() {
    }

    private static final Function<By,ExpectedCondition> CLICKABLE = by -> ExpectedConditions.elementToBeClickable(by);
    private static final Function<By,ExpectedCondition> PRESENCE = by -> ExpectedConditions.presenceOfElementLocated(by);
    private static final Function<By,ExpectedCondition> VISABLE = by -> ExpectedConditions.elementToBeClickable(by);

    static Map<WaitStrategy,Function<By,ExpectedCondition>> MAP = new EnumMap<>(WaitStrategy.class);

    static {
        MAP.put(WaitStrategy.CLICKABLE,CLICKABLE);
        MAP.put(WaitStrategy.PRESENCE,PRESENCE);
        MAP.put(WaitStrategy.VISABLE,VISABLE);
    }

    static WebElement waitForElement(WaitStrategy waitStrategy, By by) {
        WebElement webElement = null;

        if (!(waitStrategy == WaitStrategy.NONE)) {
            webElement = (WebElement) new WebDriverWait(DriverManager.getDriver(),
                    ConfigFactory.getConfig().timeout())
                    .until(MAP.get(waitStrategy).apply(by));
        } else {
            webElement = DriverManager.getDriver().findElement(by);
        }

        return webElement;
    };

//    static WebElement waitForElement(WaitStrategy waitStrategy, By by) {
//        WebElement webElement = null;
//        if (waitStrategy == WaitStrategy.CLICKABLE) {
//            webElement = new WebDriverWait(DriverManager.getDriver(),
//                    ConfigFactory.getConfig().timeout())
//                    .until(ExpectedConditions.elementToBeClickable(by));
//        } else if (waitStrategy == WaitStrategy.PRESENCE) {
//            webElement = new WebDriverWait(DriverManager.getDriver(),
//                    ConfigFactory.getConfig().timeout())
//                    .until(ExpectedConditions.presenceOfElementLocated(by));
//        } else if (waitStrategy == WaitStrategy.VISABLE) {
//            webElement = new WebDriverWait(DriverManager.getDriver(),
//                    ConfigFactory.getConfig().timeout())
//                    .until(ExpectedConditions.visibilityOfElementLocated(by));
//        } else if (waitStrategy == WaitStrategy.NONE) {
//            webElement = DriverManager.getDriver().findElement(by);
//
//        }
//        return webElement;
//    }
}
