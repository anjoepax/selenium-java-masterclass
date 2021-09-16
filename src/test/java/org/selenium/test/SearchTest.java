package org.selenium.test;

import org.selenium.page.StorePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class SearchTest extends BaseTest {

    @Test
    public void searchProductWithPartialMatch() {
        String searchTerm = "Blue";
        StorePage storePage = new StorePage()
                .load()
                .searchProduct(searchTerm);
        Assert.assertEquals(
                storePage.getPageTitle(),
                "Search results: “"+searchTerm+"”"
        );
    }

    @Test(enabled = false)
    public void searchProductWithExactMatch() {
        String searchTerm = "Blue Denim Short";

    }
}
