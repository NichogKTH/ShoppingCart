package bo;

import db.ItemDB;

import java.util.Collection;

public class Item {

    private String name;
    private String description;
    private int id;

    static public Collection allItemsInStore() {
        return ItemDB.allItemsInStore();
    }

    static public Collection allItemsInCart() {
        return ItemDB.allItemsInCart();
    }

    static public Collection allAuthentications() {
        return ItemDB.allAuthentications();
    }

    protected Item(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static void addItemFromStoreToCart(int id, String name, String description) {
        ItemDB.addItemFromStoreToCart(id, name, description);
    }

    public static void deleteItemFromCart(int id, String name, String description) {
        ItemDB.deleteItemFromCart(id, name, description);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }
}