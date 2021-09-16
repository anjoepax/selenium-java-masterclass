package org.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.factory.ExplicitWaitFactory;


public final class StorePage extends BasePage {

    private final By searchProductTextBox = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By searchResultTitle = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage searchProduct(String searchTerm) {
        WebElement searchElement = ExplicitWaitFactory.waitForElementToBeVisible(searchProductTextBox);
        WebElement searchButtonElement = ExplicitWaitFactory.waitForElementToBeClickable(searchButton);
        searchElement.clear();
        searchElement.sendKeys(searchTerm);
        searchButtonElement.click();
        ExplicitWaitFactory.waitForUrlToContain("post_type=product");
        return this;
    }

    public String getPageTitle() {
        return ExplicitWaitFactory.waitForElementToBeVisible(searchResultTitle).getText();
    }

    public StorePage clickAddToCartButton(String productName) {
        ExplicitWaitFactory.waitForElementToBeVisible(getAddToCartButtonElement(productName)).click();
        return this;
    }

    public CartPage clickViewCartLink() {
        ExplicitWaitFactory.waitForElementToBeVisible(viewCartLink).click();
        return new CartPage();
    }

    private By getAddToCartButtonElement(String productName) {
        return By.cssSelector("a[aria-label='Add “"+productName+"” to your cart']");
    }

    public StorePage load() {
        loadUrl("/store");
        return this;
    }
}
