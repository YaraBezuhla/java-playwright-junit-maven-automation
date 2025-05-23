package journal.reading.automation.core.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new RuntimeException("Не вдалося знайти config.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Не вдалося завантажити config.properties ", ex);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
