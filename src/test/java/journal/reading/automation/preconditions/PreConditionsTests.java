package journal.reading.automation.preconditions;

import io.qameta.allure.Description;
import journal.reading.automation.services.api.ApiMethods;
import journal.reading.automation.testData.providers.BookDataProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PreConditionsTests {
    ApiMethods apiMethods = new ApiMethods();

    @BeforeAll
    public void beforeAll() {
        apiMethods.createPlaywright();
        apiMethods.createApiRequest();
    }
    @Test
    @Description("Видалити книгу за допомогою АПІ")
    public void deleteBookByApiTest() {
        apiMethods.deleteBookByApi(BookDataProvider.getBookTitles());
    }
}
