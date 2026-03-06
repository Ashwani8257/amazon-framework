package com.automation.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CartPage {
    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public String getItemName() {

        Locator itemName = page.locator("span.a-truncate-cut").first();

        itemName.waitFor();

        return itemName.innerText().trim();
    }
    public String getQuantity() {

        Locator quantity = page.locator("span[data-a-selector='inner-value']").first();

        quantity.waitFor();

        return quantity.innerText().trim();
    }
}
