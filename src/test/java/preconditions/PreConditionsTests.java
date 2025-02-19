package preconditions;

import journal.reading.automation.api.ApiMethods;
import org.junit.jupiter.api.Test;

public class PreConditionsTests {
    ApiMethods apiMethods = new ApiMethods();

    @Test
    public void deleteBookByApiTest() {
        apiMethods.deleteBookByApi();
    }
}
