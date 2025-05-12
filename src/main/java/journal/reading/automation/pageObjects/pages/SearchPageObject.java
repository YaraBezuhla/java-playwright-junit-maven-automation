package journal.reading.automation.pageObjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.qameta.allure.Step;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SearchPageObject {
    private final Locator searchInput;
    private final Locator titleBook;
    private final Locator authorBook;

    public SearchPageObject(Page page) {
        this.searchInput = page.getByRole(AriaRole.SEARCHBOX);
        this.titleBook = page.locator("//h3[@data-test='search-book-title']");
        this.authorBook = page.locator("//p[@data-test='search-book-author']");
    }

    @Step("Ввести запит пошуку назву або автора книги")
    public void inputTextInSearchInput(String searchText) {
        searchInput.fill(searchText);
    }

    @Step("Перевірити результат пошуку по назві книги")
    public void assertBookFoundByName(String expectedTitle) {
        assertThat(titleBook).hasText(expectedTitle);
    }

    @Step("Перевірити результат пошуку по автору книги")
    public void assertBookFoundByAuthor(String expectedAuthor) {
        assertThat(authorBook).hasText(expectedAuthor);
    }

}
