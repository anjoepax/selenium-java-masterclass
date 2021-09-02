package org.selenium.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.constants.FrameworkConstants;
import org.selenium.driver.DriverManager;
import java.time.Duration;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {}

    public static WebElement waitForElementToBeVisible(By locator) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForPresenceOfElement(By locator) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementToBeInvisible(By locator) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(StaleElementReferenceException.class, NoSuchElementException.class)
                .until(driver -> !DriverManager.getDriver().findElement(locator).isDisplayed());
    }

    public static void waitForElementTextToBe(By locator, String text) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForElementTextValue(By locator, String text) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.textToBe(locator, text));
    }

    public static boolean waitForUrlToContain(String relPath) {
        return new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.urlContains(relPath));
    }
}
