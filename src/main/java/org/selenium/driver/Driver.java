package org.selenium.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.enums.BrowserType;
import java.util.Objects;

public final class Driver {

    private Driver() {}

    public static void setBrowserDriver() {
        String browser = System.getProperty("browser", "CHROME");
        String driverPath = "Drivers";

        switch (BrowserType.valueOf(browser.toUpperCase().trim())) {
            case CHROME:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.chromedriver().cachePath(driverPath).setup();
                    DriverManager.setDriver(new ChromeDriver());
                }
                break;

            case EDGE:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.edgedriver().cachePath(driverPath).setup();
                    DriverManager.setDriver(new EdgeDriver());
                }
                break;

            case FIREFOX:
                if(Objects.isNull(DriverManager.getDriver())) {
                    WebDriverManager.firefoxdriver().cachePath(driverPath).setup();
                    DriverManager.setDriver(new FirefoxDriver());
                }
                break;

            default:
                throw new IllegalStateException("Invalid browser name: " + browser);
        }
    }

    public static void quitBrowserDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}

