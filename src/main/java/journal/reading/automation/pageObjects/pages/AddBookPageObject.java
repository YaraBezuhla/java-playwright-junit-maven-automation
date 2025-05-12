package journal.reading.automation.pageObjects.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import io.qameta.allure.Step;

public class AddBookPageObject {
    private final Locator titleInput;
    private final Locator authorInput;
    private final Locator genreSelect;
    private final Locator saveButton;

    public AddBookPageObject(Page page) {
        titleInput = page.locator("//input[@id='title']");
        authorInput = page.locator("//input[@id='author']");
        genreSelect = page.locator("//select[@id='genre']");
        saveButton = page.locator("//button[@type='submit']");
    }

    @Step("Ввести назву книги")
    public void enterTitle(String title) {
        titleInput.fill(title);
    }

    @Step("Ввести автора книги")
    public void enterAuthor(String author) {
        authorInput.fill(author);
    }

    @Step("Обрати жанр книги")
    public void selectGenre(String genre) {
        genreSelect.selectOption(genre);
    }

    @Step("Клікнути на кнопку 'Зберегти'")
    public void clickButton() {
        saveButton.click();
    }

}
