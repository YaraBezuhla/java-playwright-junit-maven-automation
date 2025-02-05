import journal.reading.automation.LaunchSettings;
import journal.reading.automation.database.GetDataFromMongoDB;
import journal.reading.automation.pageObjects.HomePageObjects;
import org.junit.jupiter.api.Test;

public class HomePageTests extends LaunchSettings {
    GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();
    HomePageObjects homePage = new HomePageObjects(page);

    @Test
    public void firstTest(){
        homePage.assertBlocksName();
    }
}
