package journal.reading.automation.services.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import journal.reading.automation.core.utilities.ConfigReader;
import org.bson.Document;

public class ConnectMongoDBSingleton {
    private static volatile ConnectMongoDBSingleton instance;

    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private ConnectMongoDBSingleton() {
        mongoClient = MongoClients.create(ConfigReader.get("mongodb.uri"));
        mongoDatabase = mongoClient.getDatabase(ConfigReader.get("mongodb.database"));
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
