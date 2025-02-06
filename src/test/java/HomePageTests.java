import journal.reading.automation.LaunchSettings;
import journal.reading.automation.pageObjects.HomePageObjects;
import org.junit.jupiter.api.Test;

public class HomePageTests extends LaunchSettings {

    @Test
    public void firstTest(){
        HomePageObjects homePage = new HomePageObjects(page);
        homePage.assertBlocksName();
    }
}
