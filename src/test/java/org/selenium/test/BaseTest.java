package org.selenium.test;

import org.selenium.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest() {}

    @BeforeMethod(alwaysRun = true)
    public void startDiver() {
        Driver.setBrowserDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() {
        Driver.quitBrowserDriver();
    }
}

