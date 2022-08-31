package com.genspark.Inventory.Entity;

import javax.persistence.*;

@Entity
@Table(name="tbl_inventory")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    private String name;
    private int barCodeNumber;
    private String useByDate;

    public Item() {
    }

    public Item(int itemId, String name, int barCodeNumber, String useByDate) {
        this.name = name;
        this.barCodeNumber = barCodeNumber;
        this.useByDate = useByDate;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBarCodeNumber() {
        return barCodeNumber;
    }

    public void setBarCodeNumber(int barCodeNumber) {
        this.barCodeNumber = barCodeNumber;
    }

    public String getUseByDate() {
        return useByDate;
    }

    public void setUseByDate(String useByDate) {
        this.useByDate = useByDate;
    }
}
