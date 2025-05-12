package journal.reading.automation.uiTests;

import io.qameta.allure.Description;
import journal.reading.automation.pageObjects.PageObjectsFacade;
import journal.reading.automation.core.config.BaseTestWithSpring;
import journal.reading.automation.testData.utility.DataManipulation;
import journal.reading.automation.services.database.GetDataFromMongoDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;

@SpringJUnitConfig(BaseTestWithSpring.class)
public class HomePageTests {

    private final PageObjectsFacade pageObjectsFacade;

    @Autowired
    public HomePageTests(PageObjectsFacade pageObjectsFacade) {
        this.pageObjectsFacade = pageObjectsFacade;
    }

    @Test
    @Description("Порівняння книг, що є в базі і що виводяться на сайті по тайтлу")
    public void AssertBooks() {
        GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();
        DataManipulation dataManipulation = new DataManipulation();

        ArrayList<String> dbTitles = getDataFromMongoDB.getBookTitlesFromDB();
        ArrayList<String> webTitles = pageObjectsFacade.getBookTitles().getBookTitlesOnWebSite();
        dataManipulation.compareTwoArrays(dbTitles, webTitles);
    }

    @Test
    @Description("Перевірка назв блоків на головній сторінці")
    public void AssertBlockTitles() {
        pageObjectsFacade.getHomePage().assertBlocksName("Найпопулярніші книги", "Українські автори");
    }
}
