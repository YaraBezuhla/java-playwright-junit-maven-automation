package journal.reading.automation.core.config;

import com.microsoft.playwright.*;
import journal.reading.automation.core.utilities.ConfigReader;
import journal.reading.automation.core.utilities.GetScreenSize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "journal.reading.automation.pageObjects")
public class BaseTestWithSpring {

    @Bean
    public Playwright playwright() {
        return Playwright.create();
    }

    @Bean
    public Browser browser(Playwright playwright) {
        return playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
    }

    @Bean
    public BrowserContext browserContext(Browser browser) {
        return browser.newContext(
                new Browser.NewContextOptions().setViewportSize(GetScreenSize.getViewportSize())

        );
    }

    @Bean
    public Page page(BrowserContext browserContext) {
        Page page = browserContext.newPage();
        page.navigate(ConfigReader.get("url.locale"));
        return page;
    }

}
