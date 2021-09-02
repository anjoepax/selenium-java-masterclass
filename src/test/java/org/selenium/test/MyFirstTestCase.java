package org.selenium.test;

import org.selenium.data.BillingAddress;
import org.selenium.data.Product;
import org.selenium.data.User;
import org.selenium.page.CartPage;
import org.selenium.page.CheckoutPage;
import org.selenium.page.HomePage;
import org.selenium.page.StorePage;
import org.selenium.util.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public final class MyFirstTestCase extends BaseTest {

    private HomePage homePage;
    private BillingAddress billingAddress;
    private Product product;
    private User user;

    private MyFirstTestCase() {}

    @BeforeMethod
    public void setUpPagesAndData() {
        homePage = new HomePage();
        billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        product = new Product(1215);
        user = JacksonUtils.deserializeJson("user.json", User.class);
    }

    @Test
    public void guestCheckoutUsingDirectBankTransfer() {
        String searchTerm = "Blue";
        StorePage storePage = homePage.navigateToHomePage()
                .navigateToStoreUsingMenu()
                .searchProduct(searchTerm);
        Assert.assertEquals(
                storePage.getSearchResultTitle(),
                "Search results: “"+searchTerm+"”"
        );

        CartPage cartPage = storePage.clickAddToCartButton(product.getName()).clickViewCartLink();
        Assert.assertEquals(
                cartPage.getProductNameTitle(),
                product.getName()
        );

        CheckoutPage checkoutPage = cartPage
                .navigateToCheckoutPageByClickingCheckoutButton()
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderButton();
        Assert.assertEquals(
                checkoutPage.getOrderSuccessMessage(),
                "Thank you. Your order has been received."
        );
    }

    @Test
    public void loginAndCheckoutUsingDirectBankTransfer() {
        String searchTerm = "Blue";
        StorePage storePage = homePage.navigateToHomePage()
                .navigateToStoreUsingMenu()
                .searchProduct(searchTerm);
        Assert.assertEquals(
                storePage.getSearchResultTitle(),
                "Search results: “"+searchTerm+"”"
        );

        CartPage cartPage = storePage.clickAddToCartButton(product.getName()).clickViewCartLink();
        Assert.assertEquals(
                cartPage.getProductNameTitle(),
                product.getName()
        );

        CheckoutPage checkoutPage = cartPage.navigateToCheckoutPageByClickingCheckoutButton()
                .clickLoginLinkInTheCheckoutPage()
                .loginInTheCheckoutPage(user)
                .setBillingAddress(billingAddress)
                .selectDirectBankTransfer()
                .clickPlaceOrderButton();
        Assert.assertEquals(
                checkoutPage.getOrderSuccessMessage(),
                "Thank you. Your order has been received."
        );
    }
}

