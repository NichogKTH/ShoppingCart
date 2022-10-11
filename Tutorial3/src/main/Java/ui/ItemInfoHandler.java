package ui;

import bo.ItemHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemInfoHandler {
    private ArrayList<ItemInfo> theItemsInStore = new ArrayList<ItemInfo>();
    private ArrayList<ItemInfo> theItemsInCart = new ArrayList<ItemInfo>();
    private ArrayList<ItemInfo> theAuthentications = new ArrayList<ItemInfo>();

    public ItemInfoHandler() {
        Collection<ItemInfo> tempItemsInStore = ItemHandler.allItemsInStore();
        for (Iterator it = tempItemsInStore.iterator(); it.hasNext(); ) {
            ItemInfo item = (ItemInfo) it.next();
            theItemsInStore.add(new ItemInfo(item.getId(), item.getName(), item.getDescription()));
        }
        Collection<ItemInfo> tempItemsInCart = ItemHandler.allItemsInCart();
        for (Iterator it = tempItemsInCart.iterator(); it.hasNext(); ) {
            ItemInfo item = (ItemInfo) it.next();
            theItemsInCart.add(new ItemInfo(item.getId(), item.getName(), item.getDescription()));
        }
        Collection<ItemInfo> tempAuthentications = ItemHandler.allAuthentications();
        for (Iterator it = tempAuthentications.iterator(); it.hasNext(); ) {
            ItemInfo item = (ItemInfo) it.next();
            theAuthentications.add(new ItemInfo(item.getId(), item.getName(), item.getDescription()));
        }
    }

    public static String addItemFromStoreToCart(int id, String name, String description) {
        ItemHandler.addItemFromStoreToCart(id, name, description);
        return name;
    }

    public static void deleteItemFromCart(int id, String name, String description) {
        ItemHandler.deleteItemFromCart(id, name, description);
    }

    public ItemInfo getItemInStore(int i) {
        ItemInfo item = theItemsInStore.get(i);
        return item;
    }

    public ItemInfo getItemInCart(int i) {
        ItemInfo item = theItemsInCart.get(i);
        return item;
    }

    public ItemInfo getAuthentication(int i) {
        ItemInfo item = theAuthentications.get(i);
        return item;
    }

    public int noOfItemsInStore() {
        return theItemsInStore.size();
    }

    public int noOfItemsInCart() {
        return theItemsInCart.size();
    }

    public int noOfAuthentications() {
        return theAuthentications.size();
    }

}
