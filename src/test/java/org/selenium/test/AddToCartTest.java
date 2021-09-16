package org.selenium.test;

import org.selenium.data.Product;
import org.selenium.page.CartPage;
import org.selenium.page.StorePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public final class AddToCartTest extends BaseTest{

    private AddToCartTest() {}

    private StorePage storePage;
    private Product product;

    @BeforeMethod
    public void setupPagesAndData() {
        product = new Product(1215);
        storePage = new StorePage();
    }

    @Test
    public void addToCartFromStorePage() {
        CartPage cartPage = storePage
                .load()
                .clickAddToCartButton(product.getName())
                .clickViewCartLink();
        Assert.assertEquals(cartPage.getProductNameTitle(), product.getName());
    }
}
