package journal.reading.automation.testData.processor;

import journal.reading.automation.testData.enums.BookData;

import java.util.Random;

public class BookProcessor {

    public String getRandomTitle() {
        BookData[] books = BookData.values();
        int randomIndex = new Random().nextInt(books.length);
        return books[randomIndex].getTitle();
    }

    public String getRandomAuthor() {
        BookData[] authors = BookData.values();
        int randomIndex = new Random().nextInt(authors.length);
        return authors[randomIndex].getAuthor();
    }
}
