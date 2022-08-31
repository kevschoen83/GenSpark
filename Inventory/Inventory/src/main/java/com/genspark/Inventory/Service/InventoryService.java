package com.genspark.Inventory.Service;

import com.genspark.Inventory.Entity.Item;

import java.util.List;

public interface InventoryService {

    List<Item> getInventory();
    Item getItemById(int itemId);
    Item addItem(Item item);
    Item updateItem(Item item);
    String deleteItemById(int itemId);
}
