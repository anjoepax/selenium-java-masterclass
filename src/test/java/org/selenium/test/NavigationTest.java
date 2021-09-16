package org.selenium.test;

import org.selenium.page.HomePage;
import org.selenium.page.StorePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class NavigationTest extends BaseTest {

    private NavigationTest() { }

    private HomePage homePage;

    @BeforeMethod
    public void setupPage() {
        homePage = new HomePage();
    }

    @Test
    public void navigateFromHomeToStoreUsingMainMenu() {
        StorePage storePage = homePage
                .navigateToHomePage()
                .navigateToStoreUsingMenu();
        Assert.assertEquals(storePage.getPageTitle(), "Store");
    }
}
