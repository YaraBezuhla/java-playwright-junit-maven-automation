package journal.reading.automation.services.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiMethods {

    private Playwright playwright;
    private APIRequestContext request;

    public void createPlaywright() {
        playwright = Playwright.create();
    }

    public void createApiRequest() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        request = playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("http://localhost:5000")
                .setExtraHTTPHeaders(headers));
    }

    @Step("Додати книгу через АПІ")
    public void addBookByApi(Map<String, Object> book, int codeResponse) {

        try {
            String requestBody = new ObjectMapper().writeValueAsString(book);

            APIResponse response = request.post("/api/books", RequestOptions.create().setData(requestBody));
            int codeResponseActual = response.status();
            assertEquals(codeResponse, codeResponseActual);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }

    @Step("Видалити книгу через АПІ")
    public void deleteBookByApi(List<String> bookTitles) {
        try {
            for (String title : bookTitles){
                if (title == null || title.isEmpty()) {
                    System.out.println("Книга без назви пропущена");
                    continue;
                }

                try {
                    request.delete("/api/books/title/" + title).ok();
                } catch (AssertionError e) {
                    System.out.println("Книга \"" + title + "\" не знайдена в базі даних. Пропущено.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Помилка під час обробки JSON або виконання запиту");
        }
    }
}

