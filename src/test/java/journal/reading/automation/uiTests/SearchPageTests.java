package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import journal.reading.automation.core.config.BaseTestClassic;
import journal.reading.automation.pageObjects.components.HeaderComponent;
import journal.reading.automation.testData.providers.EnumBookProvider;
import journal.reading.automation.pageObjects.pages.SearchPageObject;
import org.junit.jupiter.api.Test;

@Feature("Пошук книг")
public class SearchPageTests extends BaseTestClassic {

    @Test
    @Description("Перевірка пошуку книги по назві")
    public void checkSearchTitle() {
        HeaderComponent header = new HeaderComponent(page);
        SearchPageObject searchPage = new SearchPageObject(page);
        EnumBookProvider enumBookProvider = new EnumBookProvider();

        header.goToSearchPage();
        String title = enumBookProvider.getRandomTitle();
        searchPage.inputTextInSearchInput(title);
        searchPage.assertBookFoundByName(title);
    }

    @Test
    @Description("Перевірка пошуку книг по автору")
    public void checkSearchAuthor() {
        HeaderComponent header = new HeaderComponent(page);
        SearchPageObject searchPage = new SearchPageObject(page);
        EnumBookProvider enumBookProvider = new EnumBookProvider();

        String author = enumBookProvider.getRandomAuthor();
        header.goToSearchPage();
        searchPage.inputTextInSearchInput(author);
        searchPage.assertBookFoundByAuthor(author);
    }
}
