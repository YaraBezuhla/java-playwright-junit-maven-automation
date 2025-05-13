package journal.reading.automation.preconditions;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import journal.reading.automation.services.api.ApiMethods;
import journal.reading.automation.testData.providers.JsonBookProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import java.util.List;

@Feature("PreConditionsTests")
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
        apiMethods.deleteBookByApi(JsonBookProvider.getBookTitles());
    }

    @ParameterizedTest
    @MethodSource("bookTitlesProvider")
    public void parameterizedDeleteBooks(List<String> titles) {
        apiMethods.deleteBookByApi(titles);
    }

    @Description("Видалити книгу за допомогою АПІ через параметризацію")
    static Stream<List<String>> bookTitlesProvider() {
        return Stream.of(
                List.of("1984"),
                List.of("The Great Gatsby"),
                List.of("To Kill a Mockingbird")
        );
    }
}
