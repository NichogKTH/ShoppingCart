package db;

import com.mongodb.client.*;

public class DBManager {
    private final MongoClient client;
    private final MongoDatabase db;
    private final MongoCollection collectionOfItemsInStore;
    private final MongoCollection collectionOfItemsInCart;
    private final MongoCollection collectionOfAuthentication;

    private final String connectionString = "mongodb://localhost:27017";

    public DBManager (){
        client = MongoClients.create(connectionString);
        db = client.getDatabase("JSP");
        collectionOfItemsInStore = db.getCollection("ItemsInStore");
        collectionOfItemsInCart = db.getCollection("ItemsInCart");
        collectionOfAuthentication = db.getCollection("Authentication");
    }

    public MongoCollection getCollectionOfItemsInStore(){
        return collectionOfItemsInStore;
    }

    public MongoCollection getCollectionOfItemsInCart() {
        return collectionOfItemsInCart;
    }

    public MongoCollection getCollectionOfAuthentications() {
        return collectionOfAuthentication;
    }
}
