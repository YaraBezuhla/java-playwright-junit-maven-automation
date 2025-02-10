package journal.reading.automation.database;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class DataManipulation {
    public void compareDataFromWebsiteAndDatabase(ArrayList<String> dbData, ArrayList<String> webData) {
        List<String> sortedDbData = dbData.stream().sorted().toList();
        List<String> sortedWebData = webData.stream().sorted().toList();

        if (!sortedDbData.equals(sortedWebData)) {
            List<String> missingOnWebsite = sortedDbData.stream()
                    .filter(title -> !sortedWebData.contains(title))
                    .toList();
            List<String> missingInDatabase = sortedWebData.stream()
                    .filter(title -> !sortedDbData.contains(title))
                    .toList();

            StringBuilder errorMessage = new StringBuilder("Дані не співпадають:").append("\n");
            if (!missingOnWebsite.isEmpty()) {
                errorMessage.append("Дані є в базі даних, але відсутні на сайті: ").append(missingOnWebsite).append("\n");
            }
            if (!missingInDatabase.isEmpty()) {
                errorMessage.append("Дані на сайті, але відсутні в базі даних: ").append(missingInDatabase).append("\n");
            }
            Assertions.fail(errorMessage.toString());
        }

    }
}
