package com.genspark.Inventory.Controller;

import com.genspark.Inventory.Entity.Item;
import com.genspark.Inventory.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/")
    public String home() {
        return "<HTML><H1>Welcome to Inventory Management Application";
    }

    @GetMapping("/inventory")
    public List<Item> getInventory() {
        return this.inventoryService.getInventory();
    }

    @GetMapping("/inventory/{itemId}")
    public Item getItem(@PathVariable String itemId) {
        return this.inventoryService.getItemById(Integer.parseInt(itemId));
    }

    @PostMapping("/inventory")
    public Item addItem(@RequestBody Item item) {
        return this.inventoryService.addItem(item);
    }

    @PutMapping("/inventory")
    public Item updateItem(@RequestBody Item item) {
        return this.inventoryService.updateItem(item);
    }

    @DeleteMapping("/inventory/{itemId}")
    public String deleteItem(@PathVariable String itemId) {
        return this.inventoryService.deleteItemById(Integer.parseInt(itemId));
    }
}
