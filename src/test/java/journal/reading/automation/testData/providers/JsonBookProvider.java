package journal.reading.automation.testData.providers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonBookProvider {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static List<Map<String, Object>> getBooks() {
        try (InputStream is = JsonBookProvider.class.getClassLoader().getResourceAsStream("testData/books.json")) {
            if (is == null) {
                throw new RuntimeException("Файл books.json не вдалося знайти в ресурсах");
            }
            return objectMapper.readValue(is, new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException("Не вдалося прочитати books.json" + e);
        }
    }

    public static List<String> getBookTitles() {
        List<String> titles = new ArrayList<>();
        try {
            List<Map<String, Object>> books = getBooks();
            for (Map<String, Object> book : books) {
                String title = (String) book.get("title");
                if (title != null && !title.isEmpty()) {
                    titles.add(title);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Неможливо прочитати книги з файлу: ", e);
        }
        return titles;
    }
}
