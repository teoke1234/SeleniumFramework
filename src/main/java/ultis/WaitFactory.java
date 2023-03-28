package ultis;

import config.ConfigFactory;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public final class WaitFactory {

    private WaitFactory() {
    }

    static WebElement waitForElement(WaitStrategy waitStrategy, By by) {
        WebElement webElement = null;
        if (waitStrategy == WaitStrategy.CLICKABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(),
                    ConfigFactory.getConfig().timeout())
                    .until(ExpectedConditions.elementToBeClickable(by));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            webElement = new WebDriverWait(DriverManager.getDriver(),
                    ConfigFactory.getConfig().timeout())
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        } else if (waitStrategy == WaitStrategy.VISABLE) {
            webElement = new WebDriverWait(DriverManager.getDriver(),
                    ConfigFactory.getConfig().timeout())
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        } else if(waitStrategy == WaitStrategy.NONE){
            webElement = DriverManager.getDriver().findElement(by);

        }
        return webElement;
    }
}
