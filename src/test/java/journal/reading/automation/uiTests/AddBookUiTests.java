package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.core.config.BaseTestClassic;
import journal.reading.automation.pageObjects.components.BookTitlesComponent;
import journal.reading.automation.pageObjects.components.HeaderComponent;
import journal.reading.automation.pageObjects.pages.AddBookPageObject;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class AddBookUiTests extends BaseTestClassic {

    @ParameterizedTest
    @CsvSource({
            "'1984', 'George Orwell', 'Біографія'",
            "'The Great Gatsby', 'F. Scott Fitzgerald', 'Роман'",
            "'To Kill a Mockingbird', 'Harper Lee', 'Пригоди'"
    })
    @Description("Успішно додати книгу через форму на сайті")
    public void addBookTest(String title, String author, String genre){
        HeaderComponent header = new HeaderComponent(page);
        AddBookPageObject addBook = new AddBookPageObject(page);
        BookTitlesComponent bookTitles = new BookTitlesComponent(page);

        header.goToAddBook();
        addBook.enterTitle(title);
        addBook.enterAuthor(author);
        addBook.selectGenre(genre);
        addBook.clickButton();
        header.goToHomePage();
        bookTitles.checkAvailabilityBook(title);
    }
}
