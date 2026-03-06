package com.automation.tests.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.regex.Pattern;

public class CartPage {
    private Page page;

    public CartPage(Page page) {
        this.page = page;
    }

    public String getItemName() {

        Locator itemName = page.getByRole(AriaRole.LINK,
                new Page.GetByRoleOptions()
                        .setName(Pattern.compile("HP Smart Tank 589")));

        itemName.waitFor();

        return itemName.textContent().trim();
    }
    public String getQuantity() {

        Locator quantity = page.locator("span[data-a-selector='inner-value']").first();

        quantity.waitFor();

        return quantity.innerText().trim();
    }
}
