package journal.reading.automation.apiTests;

import io.qameta.allure.Description;
import journal.reading.automation.services.api.ApiMethods;
import journal.reading.automation.testData.providers.JsonBookProvider;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Map;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddBooksApiTests {

    ApiMethods apiMethods = new ApiMethods();
    List<Map<String, Object>> books;

    @BeforeAll
    public void beforeAll() {
        apiMethods.createPlaywright();
        apiMethods.createApiRequest();
        books = JsonBookProvider.getBooks();
    }

    @Test
    @Description("Перевірка успішного додавання книги через АПІ")
    public void successfulAddingBookTest() {
        apiMethods.addBookByApi(books.get(0), 201);
    }

    @Test
    @Description("Перевірка, що через АПІ не можна додати книгу, яка вже є в базі")
    public void unsuccessfulAddingDuplicateBookTest() {
        apiMethods.addBookByApi(books.get(1), 201);
        apiMethods.addBookByApi(books.get(1), 409);
    }
}
