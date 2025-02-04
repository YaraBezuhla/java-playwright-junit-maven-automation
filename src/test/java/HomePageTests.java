import journal.reading.automation.database.GetDataFromMongoDB;
import org.junit.jupiter.api.Test;

public class HomePageTests {
    GetDataFromMongoDB getDataFromMongoDB = new GetDataFromMongoDB();

    @Test
    public void firstTest(){
        getDataFromMongoDB.getBookTitlesFromDB();
    }
}
