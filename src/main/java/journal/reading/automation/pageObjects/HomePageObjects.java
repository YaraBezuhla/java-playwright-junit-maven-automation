package journal.reading.automation.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomePageObjects {

    private final Locator blocksTitles;

    public HomePageObjects(Page page) {
        this.blocksTitles = page.getByTestId("popular-block-title");
    }

    public void assertBlocksName(String... expectedTitles) {
        assertThat(blocksTitles).hasText(expectedTitles);
    }
}
