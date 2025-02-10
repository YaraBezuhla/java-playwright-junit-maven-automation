package journal.reading.automation.pageObjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BookTitlesComponent {
    private Page page;
    private Locator booksTitles;
    private Locator showMoreBtn;

    public BookTitlesComponent(Page page) {
        this.page = page;
        this.booksTitles = page.locator("//h3[@name]");
        this.showMoreBtn = page.locator("//div[@data-test='top-books']").
                getByRole(AriaRole.BUTTON);
    }

    public ArrayList<String> getBookTitlesOnWebSite() {
        while (true) {
            try {
                if (showMoreBtn.isVisible()) {
                    showMoreBtn.click();
                } else {
                    break;
                }
            } catch (NoSuchElementException e) {
                break;
            }
        }

        ArrayList<String> bookName = (ArrayList<String>) booksTitles.allInnerTexts();
        return bookName;
    }
}
