package com.fpt.tests;

import annotations.FrameworkAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import ultis.DataProviderUtils;
import testdata.TestData;

public class LoginPageTest extends BaseTest {

    @FrameworkAnnotations(author = "AnhNT84")
    @Test(description = "to check whether title will be Logged In Successfully | Practice Test Automation"
           , dataProviderClass = DataProviderUtils.class , dataProvider = "getData"
    )
    public void loginTest(TestData testData) {
        LoginPage loginPage = new LoginPage();
        String titleHomePage = loginPage
                .loginSuccesfully(testData.username, testData.password)
                .getTitleHomePage();
        Assert.assertEquals(titleHomePage, testData.titleHomePageExpected);
    }


    @FrameworkAnnotations(author = "AnhNT84")
    @Test(description = "to check whether can go Homepage when haven't login", dataProvider = "getData",
            dataProviderClass = DataProviderUtils.class
    )
    public void clickHome(TestData testData) {
        LoginPage loginPage = new LoginPage();
        String titleHomePage = loginPage.clickHome().getTitleHomePage();
        Assert.assertEquals(titleHomePage, testData.titleHomePageExpected);
    }


}
