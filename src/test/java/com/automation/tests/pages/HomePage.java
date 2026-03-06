package com.automation.tests.pages;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void searchProduct(String product) {

        page.fill("#twotabsearchtextbox", product);

        page.keyboard().press("Enter");
    }

    public Page clickProduct(String productName) {

        Page productPage = page.context().waitForPage(() -> {
            page.locator("h2:has-text('" + productName + "')")
                    .first()
                    .click();
        });

        productPage.waitForLoadState();

        System.out.println("Clicked product: " + productName);

        return productPage;
    }

}
