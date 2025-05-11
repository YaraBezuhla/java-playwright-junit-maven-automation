package journal.reading.automation.testData.providers;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class DataManipulation {

    @Step("Порівняння двох масивів")
    public void compareTwoArrays(ArrayList<String> firstArray, ArrayList<String> secondArray) {
        List<String> sortedDbData = firstArray.stream().sorted().toList();
        List<String> sortedWebData = secondArray.stream().sorted().toList();

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
