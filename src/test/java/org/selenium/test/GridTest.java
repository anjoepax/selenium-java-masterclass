package org.selenium.test;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
import java.net.URL;

public final class GridTest {

    @SneakyThrows
    @Test
    public void firstTestInGrid() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WINDOWS);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
        driver.get("https://google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
