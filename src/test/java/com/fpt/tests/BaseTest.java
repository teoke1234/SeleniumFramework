package com.fpt.tests;

import driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testdata.TestData;

import java.util.Map;

public class BaseTest {

    protected BaseTest() {
    }

    @BeforeMethod()
    protected void setUp(Object[] data){
        TestData testData = (TestData) data[0];
        Driver.initDriver(testData.getBrowsername(), testData.getVersion());
    }

    @AfterMethod
    protected void tearDown() {
        Driver.quitDriver();
    }
}
