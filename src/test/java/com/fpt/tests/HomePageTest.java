package com.fpt.tests;

import annotations.FrameworkAnnotations;
import config.ConfigFactory;
import enums.CategoryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import ultis.DataProviderUtils;
import testdata.TestData;


public class HomePageTest extends BaseTest {


    @FrameworkAnnotations(author = "AnhNT84", category = {CategoryType.MINIREGRESSION,CategoryType.REGRESSTION})
    @Test(description = "to check whether title will be © Copyright 2020 Practice Test Automation. All rights reserved | Privacy Policy"
            ,dataProviderClass = DataProviderUtils.class,dataProvider = "getData")
    public void loginTestfooter(TestData testData) {
        LoginPage loginPage = new LoginPage();
        String footertext = loginPage
                .loginSuccesfully(testData.getUsername(), testData.getPassword())
                .getFootertext();
        Assert.assertEquals(footertext,testData.getFooterTextExpected());
    }


}
