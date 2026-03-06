package com.automation.driver;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    private static ThreadLocal<Playwright> playwright = new ThreadLocal<>();
    private static ThreadLocal<Browser> browser = new ThreadLocal<>();
    private static ThreadLocal<Page> page = new ThreadLocal<>();

    public static void initBrowser(String browserType, boolean headless) {

        playwright.set(Playwright.create());

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(headless);

        switch (browserType.toLowerCase()) {
            case "chromium":
                browser.set(playwright.get().chromium().launch(options));
                break;
            case "firefox":
                browser.set(playwright.get().firefox().launch(options));
                break;
            default:
                throw new RuntimeException("Browser not supported");
        }

        page.set(browser.get().newPage());
    }

    public static Page getPage() {
        return page.get();
    }

    public static void tearDown() {
        browser.get().close();
        playwright.get().close();
    }
}
