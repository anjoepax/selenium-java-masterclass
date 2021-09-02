package org.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.selenium.driver.DriverManager;

public class BasePage {

    protected BasePage(){}

    protected void loadUrl(String endPoint) {
        DriverManager.getDriver().get("https://askomdch.com" + endPoint);
    }

    protected void executeJavaScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript(script);
    }

    protected void executeJavaScript(String script, By locator) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
        WebElement e = DriverManager.getDriver().findElement(locator);
        js.executeScript(script, e);
    }
}
