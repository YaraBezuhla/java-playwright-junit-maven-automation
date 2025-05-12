package journal.reading.automation.pageObjects.components;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import io.qameta.allure.Step;

public class HeaderComponent {
    private final Locator searchPage;
    private final Locator addBook;
    private final Locator homePage;

    public HeaderComponent(Page page) {
        this.searchPage = page.locator("//a[@data-test='search-link']");
        this.addBook = page.locator("//a[@data-test='add-book-link']");
        this.homePage = page.locator("//a[@data-test='home-link']");
    }

    @Step("Перейти на сторінку пошуку")
    public void goToSearchPage() {
        searchPage.click();
    }

    @Step("Перейти на сторінку 'Додати книгу'")
    public void goToAddBook() {
        addBook.click();
    }

    @Step("Перейти на головну сторінку")
    public void goToHomePage() {
        homePage.click();
    }
}
