package uiTests;

import journal.reading.automation.config.LaunchSettings;
import journal.reading.automation.datas.BookProcessor;
import journal.reading.automation.pageObjects.pages.HomePageObjects;
import journal.reading.automation.pageObjects.pages.SearchPageObject;
import org.junit.jupiter.api.Test;

public class SearchPageTests extends LaunchSettings {

    @Test
    public void checkSearchTitle() {
        HomePageObjects homePage = new HomePageObjects(page);
        SearchPageObject searchPage = new SearchPageObject(page);
        BookProcessor bookProcessor = new BookProcessor();

        String title = bookProcessor.getRandomTitle();
        homePage.goToSearchPage();
        searchPage.inputTextInSearchInput(title);
        searchPage.assertBookFoundByName(title);

    }

    @Test
    public void checkSearchAuthor() {
        HomePageObjects homePage = new HomePageObjects(page);
        SearchPageObject searchPage = new SearchPageObject(page);
        BookProcessor bookProcessor = new BookProcessor();

        String author = bookProcessor.getRandomAuthor();
        homePage.goToSearchPage();
        searchPage.inputTextInSearchInput(author);
        searchPage.assertBookFoundByAuthor(author);

    }
}
