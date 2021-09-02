package org.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.selenium.driver.DriverManager;
import org.selenium.data.BillingAddress;
import org.selenium.factory.ExplicitWaitFactory;

public final class CheckoutPage extends BasePage {

    private final By firstNameField = By.id("billing_first_name");
    private final By lastNameField = By.id("billing_last_name");
    private final By address1Field = By.id("billing_address_1");
    private final By cityField = By.id("billing_city");
    private final By postCodeField = By.id("billing_postcode");
    private final By emailField = By.id("billing_email");
    private final By placeOrderButton = By.id("place_order");
    private final By orderSuccessfullyReceivedMsg = By.cssSelector(".woocommerce-notice");
    private final By showLoginLink = By.cssSelector(".showlogin");
    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");
    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");

    public CheckoutPage enterFirstName(String name) {
        WebElement element = ExplicitWaitFactory.waitForElementToBeVisible(firstNameField);
        element.clear();
        element.sendKeys(name);
        return this;
    }

    public CheckoutPage enterLastName(String lastName) {
        DriverManager.getDriver().findElement(lastNameField).clear();
        DriverManager.getDriver().findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public CheckoutPage enterAddressLine1(String address) {
        DriverManager.getDriver().findElement(address1Field).clear();
        DriverManager.getDriver().findElement(address1Field).sendKeys(address);
        return this;
    }

    public CheckoutPage enterCity(String city) {
        DriverManager.getDriver().findElement(cityField).clear();
        DriverManager.getDriver().findElement(cityField).sendKeys(city);
        return this;
    }

    public CheckoutPage enterPostCode(String postalCode) {
        DriverManager.getDriver().findElement(postCodeField).clear();
        DriverManager.getDriver().findElement(postCodeField).sendKeys(postalCode);
        return this;
    }

    public CheckoutPage enterEmail(String email) {
        DriverManager.getDriver().findElement(emailField).clear();
        DriverManager.getDriver().findElement(emailField).sendKeys(email);
        return this;
    }

    public CheckoutPage clickPlaceOrderButton() {
        ExplicitWaitFactory.waitForElementToBeClickable(placeOrderButton).click();
        return this;
    }

    public String getOrderSuccessMessage() {
        return ExplicitWaitFactory.waitForElementToBeVisible(orderSuccessfullyReceivedMsg).getText();
    }

    public LoginPage clickLoginLinkInTheCheckoutPage() {
        ExplicitWaitFactory.waitForElementToBeClickable(showLoginLink).click();
        return new LoginPage();
    }

    public CheckoutPage setBillingAddress(BillingAddress billingAddress) {
        return enterFirstName(billingAddress.getFirstName())
                .enterLastName(billingAddress.getLastName())
                .selectCountry(billingAddress.getCountry())
                .enterAddressLine1(billingAddress.getAddressLineOne())
                .enterCity(billingAddress.getCity())
                .selectState(billingAddress.getState())
                .enterPostCode(billingAddress.getPostalCode())
                .enterEmail(billingAddress.getEmail());
    }

    public CheckoutPage selectCountry(String country) {
        Select dropDown = new Select(DriverManager.getDriver().findElement(countryDropDown));
        dropDown.selectByVisibleText(country);
        return this;
    }

    public CheckoutPage selectState(String state) {
        Select dropDown = new Select(DriverManager.getDriver().findElement(stateDropDown));
        dropDown.selectByVisibleText(state);
        return this;
    }

    public CheckoutPage selectDirectBankTransfer() {
        WebElement e = ExplicitWaitFactory.waitForElementToBeClickable(directBankTransferRadioBtn);
        if(!e.isSelected()) {
            e.click();
        }
        return this;
    }
}

