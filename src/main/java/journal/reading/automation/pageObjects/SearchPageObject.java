package journal.reading.automation.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPageObject {
    private final Locator searchInput;
    private final Locator titleBook;
    private final Locator authorBook;

    public SearchPageObject(Page page){
        this.searchInput = page.getByRole(AriaRole.SEARCHBOX);
        this.titleBook = page.locator("//h3[@data-test='search-book-title']");
        this.authorBook = page.locator("//p[@data-test='search-book-author']");
    }

    public void inputTextInSearchInput(String searchText){
        searchInput.fill(searchText);
    }

    public void assertBookFoundByName(String expectedTitle){
        assertThat(titleBook).hasText(expectedTitle);
    }

    public void assertBookFoundByAuthor(String expectedTitle){
        // Отримуємо всі тексти елементів
        List<String> authorNames = authorBook.allInnerTexts();
    }

}
