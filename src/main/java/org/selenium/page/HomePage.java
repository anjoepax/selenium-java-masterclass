package org.selenium.page;

import org.openqa.selenium.By;
import org.selenium.driver.DriverManager;

public final class HomePage extends BasePage {

    private final By storeMenuLink = By.cssSelector("li[id='menu-item-1227'] a[class='menu-link']");

    public StorePage navigateToStoreUsingMenu() {
        DriverManager.getDriver().findElement(storeMenuLink).click();
        return new StorePage();
    }

    public HomePage navigateToHomePage() {
        loadUrl("/");
        return this;
    }
}
