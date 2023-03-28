package pages.pagecomponents;

import driver.DriverManager;
import org.openqa.selenium.By;

public class FooterComponents {

    private static final By LABEL_FOOTER =By.id("site-footer");

    public String getFooterTittle(){
        return DriverManager.getDriver().findElement(LABEL_FOOTER).getText();
    }
}
