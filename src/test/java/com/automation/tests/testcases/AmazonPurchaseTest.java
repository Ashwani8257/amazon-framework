package com.automation.tests.testcases;

import com.automation.config.ConfigReader;
import com.automation.tests.base.BaseTest;
import com.automation.tests.pages.CartPage;
import com.automation.tests.pages.HomePage;
import com.automation.tests.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;

public class AmazonPurchaseTest extends BaseTest {

    @Test
    public void verifyAmazonCartFlow() {

        HomePage home = new HomePage(page);

        String searchProduct = ConfigReader.get("searchProduct");
        String productName = ConfigReader.get("productName");
        String quantity = ConfigReader.get("quantity");

        home.searchProduct(searchProduct);

        // ⭐ Capture new tab
        Page productPage = home.clickProduct(productName);

        System.out.println("Product name from config: " + productName);

        productPage.waitForLoadState();

        // ⭐ Use new page for product actions
        ProductPage product = new ProductPage(productPage);

        product.selectQuantity(quantity);

        product.addToCart();

        product.goToCart();


        CartPage cart = new CartPage(productPage);

        productPage.waitForLoadState();

        String cartItem = cart.getItemName();

        System.out.println("Cart Item Name: " + cartItem);



        Assert.assertTrue(cartItem.contains(productName));

        String cartQty = cart.getQuantity();

        System.out.println("Cart Quantity: " + cartQty);

        Assert.assertEquals(cartQty, quantity);

    }
}