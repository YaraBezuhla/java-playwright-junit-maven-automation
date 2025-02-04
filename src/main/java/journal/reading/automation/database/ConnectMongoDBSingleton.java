package journal.reading.automation.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConnectMongoDBSingleton {
    private static volatile ConnectMongoDBSingleton instance;

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private ConnectMongoDBSingleton() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        mongoDatabase = mongoClient.getDatabase("automationreadingjournal");
    }

    public static ConnectMongoDBSingleton getInstance() {
        if (instance == null) {
            synchronized (ConnectMongoDBSingleton.class) {
                if (instance == null) {
                    instance = new ConnectMongoDBSingleton();
                }
            }
        }
        return instance;
    }

    public MongoCollection<Document> getCollectionMongoDB(String nameCollection) {
        return mongoDatabase.getCollection(nameCollection);
    }

}
