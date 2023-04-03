package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import pages.pagecomponents.ControlBarComponents;
import reports.ReportLogs;

import java.lang.reflect.Method;

import static ultis.SeleniumUtils.click;
import static ultis.SeleniumUtils.sendKeys;

public class LoginPage {

    private static final By TXTBOX_USERNAME = By.id("username");
    private static final By TXTBOX_PASSWORD = By.id("password");
    private static final By BTN_LOGIN = By.id("submit");

    private final ControlBarComponents controlBarComponents;

    public LoginPage() {
        controlBarComponents = new ControlBarComponents();
    }


    private LoginPage setUsername(String username) {
        sendKeys(TXTBOX_USERNAME, username, WaitStrategy.PRESENCE, "Username TextBox");
        return this;
    }

    private LoginPage setPassword(String password) {
        sendKeys(TXTBOX_PASSWORD, password, WaitStrategy.PRESENCE,"Password TextBox");
        return this;
    }

    private void clickLoginbtn() {
        click(BTN_LOGIN, WaitStrategy.CLICKABLE, "Login button");
    }

    public HomePage clickHome() {
        controlBarComponents.clickHome();
        return new HomePage();
    }

    public HomePage loginSuccesfully(String username, String password) {
        setUsername(username).setPassword(password).clickLoginbtn();
        return new HomePage();
    }
}
