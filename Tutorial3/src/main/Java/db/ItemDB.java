package db;

import bo.Item;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;

import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {
    public static Collection allItemsInStore() {
        DBManager itemDatabase = new DBManager();
        MongoCollection collection = itemDatabase.getCollectionOfItemsInStore();
        return generateUncoupledCollection(collection);
    }

    public static void addItemFromStoreToCart(int id, String name, String description) {
        DBManager itemDatabase = new DBManager();
        MongoCollection collectionOfItemsInCart = itemDatabase.getCollectionOfItemsInCart();
        Document document = new Document("_id", id);
        document.append("name", name);
        document.append("description", description);
        boolean alreadyInCollection = false;
        MongoCursor<Document> cursor = collectionOfItemsInCart.find().iterator();
        while (cursor.hasNext()) {
            Document current = cursor.next();
            String namesInCart = current.get("name").toString();
            if (namesInCart.equals(name)) alreadyInCollection = true;
        }
        if (!alreadyInCollection)
            collectionOfItemsInCart.insertOne(document);
    }

    public static void deleteItemFromCart(int id, String name, String description) {
        DBManager itemDatabase = new DBManager();
        MongoCollection collectionOfItemsInCart = itemDatabase.getCollectionOfItemsInCart();
        Document document = new Document("_id", id);
        document.append("name", name);
        document.append("description", description);
        collectionOfItemsInCart.findOneAndDelete(document);
    }

    public static Collection allItemsInCart() {
        DBManager itemDatabase = new DBManager();
        MongoCollection collection = itemDatabase.getCollectionOfItemsInCart();
        return generateUncoupledCollection(collection);
    }

    public static Collection allAuthentications() {
        DBManager itemDatabase = new DBManager();
        MongoCollection collection = itemDatabase.getCollectionOfAuthentications();
        Vector v = new Vector();
        MongoCursor<Document> cursor = collection.find().iterator();
        while (cursor.hasNext()) {
            Document current = cursor.next();
            String username = current.get("username").toString();
            String password = current.get("password").toString();
            int id = (int) current.get("_id");
            v.addElement(new ItemDB(id, username, password));
        }
        return v;
    }

    private static Collection generateUncoupledCollection(MongoCollection c) {
        Vector v = new Vector();
        MongoCursor<Document> cursor = c.find().iterator();
        while (cursor.hasNext()) {
            Document current = cursor.next();
            String name = current.get("name").toString();
            String description = current.get("description").toString();
            int id = (int) current.get("_id");
            v.addElement(new ItemDB(id, name, description));
        }
        return v;
    }

    private ItemDB(int id, String name, String desc) {
        super(id, name, desc);
    }
}

