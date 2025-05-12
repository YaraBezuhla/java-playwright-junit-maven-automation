package journal.reading.automation.testData.enums;

public enum BookData {
    INTERNAT("Інтернат", "Сергій Жадан"),
    INTERMEZZO("Білий попіл", "Ілларіон Павлю"),
    YOUAREINTERESTEDDARKNESS("Я бачу, вас цікавить пітьма", "Ілларіон Павлюк");

    private final String title;
    private final String author;

    BookData(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
