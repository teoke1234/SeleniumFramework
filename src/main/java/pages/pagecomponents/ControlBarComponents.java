package pages.pagecomponents;

import org.openqa.selenium.By;

import static ultis.SeleniumUtils.click;

public class ControlBarComponents {

    private static final By BTN_HOME = By.id("menu-item-43");

    public void clickHome(){
        click(BTN_HOME, "Home Button");
    }
}
