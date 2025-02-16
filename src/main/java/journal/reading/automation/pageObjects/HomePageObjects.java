package journal.reading.automation.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class HomePageObjects {

    private final Locator blocksTitles;
    private final Locator showMoreAuthorsBtn;
    private final Locator authorName;
    private final Locator searchPage;

    @Autowired
    public HomePageObjects(Page page) {
        this.blocksTitles = page.getByTestId("popular-block-title");
        this.showMoreAuthorsBtn = page.locator("//div[@data-test='top-authors']").
                getByRole(AriaRole.BUTTON);
        this.authorName = page.locator("//div[@data-test='author-card']/h3");
        this.searchPage = page.locator("//a[@data-test='search-link']");
    }

    public void assertBlocksName(String... expectedTitles) {
        assertThat(blocksTitles).hasText(expectedTitles);
    }

    public void goToAuthorPage(String expectedAuthor) {
        while (true) {
            try {
                if (showMoreAuthorsBtn.isVisible()) {
                    showMoreAuthorsBtn.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        int countAuthors = authorName.count();

        for (int i = 0; i < countAuthors; i++) {
            String name = authorName.nth(i).innerText();
            if (name.contains(expectedAuthor)) {
                authorName.nth(i).click();
                break;
            }
        }
    }

    public void goToSearchPage() {
        searchPage.click();
    }
}

