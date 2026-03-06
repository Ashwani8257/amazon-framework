package com.automation.tests.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ProductPage
{
    private Page page;

    public ProductPage(Page page) {
        this.page = page;
    }

    public void selectQuantity(String quantity) {

        System.out.println("Selecting Quantity: " + quantity);
        page.selectOption("#quantity", quantity);
    }

    public void addToCart() {
        page.locator("//input[@id='add-to-cart-button']").scrollIntoViewIfNeeded();

        page.click("//input[@id='add-to-cart-button']");

        System.out.println("Added To Cart");
    }

    public void goToCart() {

        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Go to Cart")).click();
        System.out.println("Go To Cart");
    }
}
