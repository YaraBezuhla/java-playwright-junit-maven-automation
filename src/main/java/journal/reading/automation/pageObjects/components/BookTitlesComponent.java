package journal.reading.automation.pageObjects.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@Component
public class BookTitlesComponent {
    private final Locator booksTitles;
    private final ShowMoreBtn showMoreBtn;

    @Autowired
    public BookTitlesComponent(Page page) {
        this.booksTitles = page.locator("//h3[@name]");
        showMoreBtn = new ShowMoreBtn(page);
    }

    @Step("Отримати назви книг")
    public ArrayList<String> getBookTitlesOnWebSite() {
        showMoreBtn.clickShowMoreBooks();
        return (ArrayList<String>) booksTitles.allInnerTexts();
    }

    @Step("Перевірити наявність книг")
    public void checkAvailabilityBook(String... bookExpected) {
        showMoreBtn.clickShowMoreBooks();
        assertThat(booksTitles).containsText(bookExpected);
    }
}
