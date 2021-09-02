package org.selenium.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

    private static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    private DriverManager() {}

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driver) {
        dr.set(driver);
    }

    public static void unloadDriver() {
        dr.remove();
    }
}
