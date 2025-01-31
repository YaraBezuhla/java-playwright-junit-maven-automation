package journal.reading.automation.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ApiMethods {

    private Playwright playwright;
    private APIRequestContext request;

    private static final String BOOKS_JSON_FILE = "C:/Users/Ярослава/Projects/playwright-automation-reading-journal/src/test/resources/testData/books.json";

    public void createAPIRequestContext(int bookIndex) {

        try {
            playwright = Playwright.create();
            Map<String, String> headers = new HashMap<>();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(new File(BOOKS_JSON_FILE)); // Читання JSON у дерево об'єктів
            JsonNode selectedBook = jsonNode.get(bookIndex);
            String requestBody = objectMapper.writeValueAsString(selectedBook);  // Перетворення JsonNode у JSON-рядок


            headers.put("Content-Type", "application/json");
            request = playwright.request().newContext(new APIRequest.NewContextOptions()
                    .setBaseURL("http://localhost:5000/api")
                    .setExtraHTTPHeaders(headers));

            APIResponse newBook = request.post("/books", RequestOptions.create().setData(requestBody));
            //assertTrue(newBook.ok());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }
}

