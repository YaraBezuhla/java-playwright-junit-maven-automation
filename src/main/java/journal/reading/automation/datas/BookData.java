package journal.reading.automation.datas;

public enum BookData {
    INTERNAT("Інтернат", "Сергій Жадан"),
    IAMROMANTIC("Я (Романтика)", "Микола Хвильовий"),
    TIGERS("Тигролови", "Іван Багряний"),
    INTERMEZZO("Intermezzo", "Михайло Коцюбинський"),
    YOUAREINTERESTEDDARKNESS("Я бачу вас цікавить пітьма", "Ілларіон Павлюк");

    private final String title;
    private final String author;

    // Конструктор
    BookData(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Геттери
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
