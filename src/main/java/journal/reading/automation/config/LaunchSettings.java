package journal.reading.automation.config;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class LaunchSettings {

    // Shared between all tests in this class.
    static Playwright playwright;
    static Browser browser;

    // New instance for each test method.
    public BrowserContext context;
    public Page page;

  /*  @BeforeAll
    public static void setUp() {
       try (Playwright playwright = Playwright.create()) {
           Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
           Page page = browser.newPage();
           page.navigate("http://localhost:8080/");
       }*/

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }


    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("http://localhost:8080/");
    }

    @AfterEach
    void closeContext() {
        context.close();
    }
}
