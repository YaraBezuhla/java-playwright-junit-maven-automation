package journal.reading.automation.database;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

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

}
