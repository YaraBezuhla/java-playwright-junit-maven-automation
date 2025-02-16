import io.qameta.allure.Description;
import journal.reading.automation.pageObjects.PageObjectsFacade;
import journal.reading.automation.TestConfigWithSpring;
import journal.reading.automation.database.DataManipulation;
import journal.reading.automation.database.GetDataFromMongoDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;

@SpringJUnitConfig(TestConfigWithSpring.class)
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
        dataManipulation.compareDataFromWebsiteAndDatabase(dbTitles, webTitles);
    }

    @Test
    @Description("Перевірка назв блоків на головній сторінці")
    public void AssertBlockTitles() {
        pageObjectsFacade.getHomePage().assertBlocksName("Найпопулярніші книги", "Українські автори");
    }
}
