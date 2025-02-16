package journal.reading.automation.pageObjects;

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

    public HomePageObjects getHomePage() {
        return homePage;
    }

    public SearchPageObject getSearchPage() {
        return searchPage;
    }

    public BookTitlesComponent getBookTitles() {
        return bookTitles;
    }
}
