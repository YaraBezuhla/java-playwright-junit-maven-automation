package journal.reading.automation.services.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class GetDataFromMongoDB {
    ConnectMongoDBSingleton connect = ConnectMongoDBSingleton.getInstance();

    public ArrayList<String> getBookTitlesFromDB() {
        ArrayList<String> titles = new ArrayList<>();

        MongoCollection<Document> booksCollection = connect.getCollectionMongoDB("books");

        FindIterable<Document> iterable = booksCollection.find();
        for (Document doc : iterable) {
            String title = doc.getString("title");
            boolean top = doc.getBoolean("top");
            if (title != null && top) {
                titles.add(title);
            }
        }
        System.out.println(titles);
        return titles;
    }

    public ArrayList<String> getBookTitlesOneAuthorFromDatabase(String expectedAuthor) {
        ArrayList<String> titles = new ArrayList<>();

        MongoCollection<Document> authorsCollection = connect.getCollectionMongoDB("authors");

        Document authorDoc = authorsCollection.find(new Document("name", expectedAuthor)).first();
        if (authorDoc == null) {
            throw new RuntimeException("Автор не знайдений: " + expectedAuthor);
        }
        ObjectId authorId = authorDoc.getObjectId("_id");

        MongoCollection<Document> booksCollection = connect.getCollectionMongoDB("books");

        booksCollection.find(new Document("author", authorId))
                .into(new ArrayList<>())
                .stream()
                .map(doc -> doc.getString("title"))
                .forEach(titles::add);

        System.out.println(titles);
        return titles;
    }

}
