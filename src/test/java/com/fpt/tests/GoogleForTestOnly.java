package com.fpt.tests;

import annotations.FrameworkAnnotations;
import com.google.common.util.concurrent.Uninterruptibles;
import enums.CategoryType;
import org.testng.annotations.Test;
import pages.GooglePage;
import testdata.TestData;
import ultis.DataProviderUtils;

import java.util.concurrent.TimeUnit;

public class GoogleForTestOnly extends BaseTest{

    @FrameworkAnnotations(author = "AnhNT84", category = {CategoryType.MINIREGRESSION,CategoryType.REGRESSTION})
    @Test(description = "test google", dataProviderClass = DataProviderUtils.class, dataProvider = "getData")

    public void forTestOnly(TestData testData) {
        GooglePage googlePage = new GooglePage();
        googlePage.setToSearchBox(testData.getTitleHomePageExpected());
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);

    }
}
