package com.automation.config;

import com.microsoft.playwright.CLI;

import java.io.IOException;

public class BrowserInstall {
    public static void main(String[] args) throws IOException, InterruptedException {
        CLI.main(new String[]{"install"});
    }
}