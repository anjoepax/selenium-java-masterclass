package org.selenium.page;

import org.openqa.selenium.By;
import org.selenium.data.User;
import org.selenium.driver.DriverManager;
import org.selenium.factory.ExplicitWaitFactory;


public final class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.name("login");

    public CheckoutPage loginInTheCheckoutPage(User user) {
        ExplicitWaitFactory.waitForElementToBeVisible(usernameField);
        DriverManager.getDriver().findElement(usernameField).sendKeys(user.getUsername());
        DriverManager.getDriver().findElement(passwordField).sendKeys(user.getPassword());
        DriverManager.getDriver().findElement(loginButton).click();
        return new CheckoutPage();
    }
}
