package journal.reading.automation.pageObjects.components;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.NoSuchElementException;

public class ShowMoreBtn {
    private static Locator showMoreBtn;

    public ShowMoreBtn(Page page) {

        this.showMoreBtn = page.locator("//div[@data-test='top-books']//button");
    }
    public void clickShowMoreBooks(){
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
    }
}
