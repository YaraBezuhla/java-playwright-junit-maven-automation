import journal.reading.automation.api.ApiMethods;
import org.junit.jupiter.api.*;

public class AddBooksApiTests {

    ApiMethods apiMethods = new ApiMethods();

    @Test
    public void successfulAddingBookTest() {
        apiMethods.createAPIRequestContext(0, 201);
    }

    @Test
    public void unsuccessfulAddingDuplicateBookTest() {
        apiMethods.createAPIRequestContext(1, 201);
        apiMethods.createAPIRequestContext(1, 409);
    }
}
