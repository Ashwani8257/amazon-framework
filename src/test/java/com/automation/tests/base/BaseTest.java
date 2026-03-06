package com.automation.tests.base;

import com.automation.config.ConfigReader;
import com.automation.driver.PlaywrightFactory;
import com.microsoft.playwright.Page;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Page page;

    @BeforeMethod
    public void setup() {

        PlaywrightFactory.initBrowser(
                ConfigReader.get("browser"),
                Boolean.parseBoolean(ConfigReader.get("headless"))
        );

        // ⭐ IMPORTANT FIX
        page = PlaywrightFactory.getPage();

        page.navigate(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {
        //PlaywrightFactory.tearDown();
    }
}