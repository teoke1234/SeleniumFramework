package com.fpt.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import testdata.TestData;

public class TestforTest {
    @ParameterizedTest
    @MethodSource("ultis.DataProviderUtils#getData")
    void test(TestData testData){
        System.out.println(testData.getVersion());
    }
}
