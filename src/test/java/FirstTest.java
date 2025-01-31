import journal.reading.automation.LaunchSettings;
import journal.reading.automation.api.ApiMethods;
import org.junit.jupiter.api.Test;

public class FirstTest  {

    @Test
    public void firstTest() {
        ApiMethods apiMethods = new ApiMethods();
        apiMethods.createAPIRequestContext(0);
    }
}
