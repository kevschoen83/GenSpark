package com.genspark.Inventory.Service;

import com.genspark.Inventory.Dao.InventoryDao;
import com.genspark.Inventory.Entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryDao inventoryDao;

    @Override
    public List<Item> getInventory() {
        return this.inventoryDao.findAll();
    }

    @Override
    public Item getItemById(int itemId) {
        Optional<Item> i = this.inventoryDao.findById(itemId);
        Item item = null;

        if (i.isPresent()) {
            item = i.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + itemId);
        }

        return item;
    }

    @Override
    public Item addItem(Item item) {
        return this.inventoryDao.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return this.inventoryDao.save(item);
    }

    @Override
    public String deleteItemById(int itemId) {
        this.inventoryDao.deleteById(itemId);
        return "Item deleted successfully";
    }
}