package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

import static ultis.SeleniumUtils.sendKeys;

public final class GooglePage {

    private static final By SEARCH_BOX = By.name("q");

    public GooglePage setToSearchBox(String username) {
        sendKeys(SEARCH_BOX, username, WaitStrategy.PRESENCE, "Search TextBox");
        return new GooglePage();
    }
}
