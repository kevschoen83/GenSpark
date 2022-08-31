package com.genspark.Inventory.Dao;

import com.genspark.Inventory.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDao extends JpaRepository<Item, Integer> {
}
