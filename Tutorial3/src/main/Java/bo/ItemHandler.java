package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {
    public static Collection<ItemInfo> allItemsInStore() {
        Collection c = Item.allItemsInStore();
        return ItemHandler.generateUncoupledCollection(c);
    }

    public static Collection<ItemInfo> allItemsInCart() {
        Collection c = Item.allItemsInCart();
        return ItemHandler.generateUncoupledCollection(c);
    }

    public static Collection<ItemInfo> allAuthentications() {
        Collection c = Item.allAuthentications();
        return ItemHandler.generateUncoupledCollection(c);
    }

    public static void addItemFromStoreToCart(int id, String name, String description) {
        Item.addItemFromStoreToCart(id, name, description);
    }

    public static void deleteItemFromCart(int id, String name, String description) {
        Item.deleteItemFromCart(id, name, description);
    }

    private static Collection<ItemInfo> generateUncoupledCollection(Collection c) {
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext(); ) {
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getId(), item.getName(), item.getDescription()));
        }
        return items;
    }
}
