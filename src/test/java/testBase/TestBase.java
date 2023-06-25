package testBase;

import com.microsoft.playwright.*;

public class TestBase {

    public static Playwright playwright;
    public static Browser browser;

    public static BrowserContext context;
    public static Page page;

    public static void webSetup(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions());
    }

    public static void webTeardown(){
        playwright.close();
    }

    public static void webBeforeEach(){
        context = browser.newContext();
        page = context.newPage();
        page.setViewportSize(1920, 1080);
    }

    public static void webAfterEach(){
        context.close();
    }
}
