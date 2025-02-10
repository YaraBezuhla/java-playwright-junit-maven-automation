import journal.reading.automation.api.ApiMethods;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddBooksApiTests {

    ApiMethods apiMethods = new ApiMethods();

    @BeforeAll
    public void beforeAll() {
        apiMethods.createPlaywright();
        apiMethods.createApiRequest();
    }

    @Test
    public void successfulAddingBookTest() {
        apiMethods.addBookByApi(0, 201);
    }

    @Test
    public void unsuccessfulAddingDuplicateBookTest() {
        apiMethods.addBookByApi(1, 201);
        apiMethods.addBookByApi(1, 409);
    }
}
