package com.automation.tests.pages;

import com.microsoft.playwright.Page;
import org.testng.Assert;

public class SearchResultsPage {

    private Page page;

    public SearchResultsPage(Page page) {
        this.page = page;
    }

    public void verifyResultsPresent() {
        Assert.assertTrue(page.locator("div.s-search-results").isVisible());
    }

    public void selectProduct(String productName) {
        page.locator("text=" + productName).first().click();
    }
}