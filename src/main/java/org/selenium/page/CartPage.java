package org.selenium.page;

import org.openqa.selenium.By;
import org.selenium.driver.DriverManager;

public final class CartPage extends BasePage {

    private final By productNameTitle = By.cssSelector("td[class='product-name'] a");
    private final By checkoutButton = By.cssSelector(".checkout-button.button.alt.wc-forward");

    public String getProductNameTitle() {
        return DriverManager.getDriver().findElement(productNameTitle).getText();
    }

    public CheckoutPage navigateToCheckoutPageByClickingCheckoutButton() {
        DriverManager.getDriver().findElement(checkoutButton).click();
        return new CheckoutPage();
    }
}
