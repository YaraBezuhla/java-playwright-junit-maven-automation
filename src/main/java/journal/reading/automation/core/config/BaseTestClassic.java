package journal.reading.automation.core.config;

import com.microsoft.playwright.*;
import journal.reading.automation.core.utilities.ConfigReader;
import journal.reading.automation.core.utilities.GetScreenSize;
import journal.reading.automation.core.utilities.TestLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestLogger.class)
public class BaseTestClassic {

    static Playwright playwright;
    static Browser browser;

    public BrowserContext context;
    public Page page;

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
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(GetScreenSize.getViewportSize()));
        page = context.newPage();
        page.viewportSize();
        page.navigate(ConfigReader.get("url.locale"));
        PageTemp.setPage(page);
    }

   /* @AfterEach
    void closeContext() {
        context.close();
    }*/
}
