package journal.reading.automation.pageObjects;

import journal.reading.automation.pageObjects.components.*;
import journal.reading.automation.pageObjects.pages.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class PageObjectsFacade {

    @Autowired
    @Lazy
    private HomePageObjects homePage;

    @Autowired
    @Lazy
    private SearchPageObject searchPage;

    @Autowired
    @Lazy
    private BookTitlesComponent bookTitles;

    @Autowired
    @Lazy
    private AddBookPageObject addBook;

    @Autowired
    @Lazy
    private HeaderComponent headerComponent;

    public HomePageObjects getHomePage() {
        return homePage;
    }

    public SearchPageObject getSearchPage() {
        return searchPage;
    }

    public BookTitlesComponent getBookTitles() {
        return bookTitles;
    }

    public HeaderComponent getHeader() {
        return headerComponent;
    }
    public AddBookPageObject getAddBook() {return addBook; }
}
