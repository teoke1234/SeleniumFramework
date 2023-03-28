package pages;

import driver.DriverManager;
import pages.pagecomponents.ControlBarComponents;
import pages.pagecomponents.FooterComponents;

public class HomePage {
    
    private final ControlBarComponents controlBarComponents;
    private final FooterComponents footerComponents;

    public HomePage(){
        footerComponents = new FooterComponents();
        controlBarComponents = new ControlBarComponents();
    }

    public String getTitleHomePage(){
        return DriverManager.getDriver().getTitle();
    }

    public void clickHomebtn(){
        controlBarComponents.clickHome();
    }

    public String getFootertext(){
        return footerComponents.getFooterTittle();
    }
}
