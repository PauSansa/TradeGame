package com.pausansa.Entity.NPC;

import com.pausansa.Entity.Item.Item;
import com.pausansa.Entity.Item.ItemBuilder;
import com.pausansa.Exceptions.InventoryFull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public abstract class NPC implements Serializable {
    static int npcCount = 0;
    int id;
    float fee;
    int maxItems;
    String city;
    float deterioration;
    ItemBuilder itemBuilder;
    List<Item> stock;

    public void sellItem(Item item){
        stock.remove(item);
        System.out.printf("%nThe item %s has been bought for %.2f€, (%.2f€ * %.2f fees %n)",item.getName(),item.getPrice()+(item.getPrice()*this.fee),item.getPrice(),this.getFee());
    }
    public void buyItem(Item item) throws InventoryFull{
        if(this.stock.size()>= this.maxItems){
            throw new InventoryFull("The inventory of this NPC is full");
        }
        item.setPercentageRusted(item.getPercentageRusted()+this.deterioration);
        stock.add(item);
        System.out.println("Article Bought:");
        System.out.println(item);
    }

    public NPC(float fee, int maxItems,float deterioration, String city, ItemBuilder itemBuilder) {
        this.id = npcCount++;
        this.fee = fee;
        this.maxItems = maxItems;
        this.deterioration = deterioration;
        this.city = city;
        this.stock = new ArrayList<>();
        this.itemBuilder = itemBuilder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getDeterioration() {
        return deterioration;
    }

    public void setDeterioration(float deterioration) {
        this.deterioration = deterioration;
    }

    public List<Item> getStock() {
        return stock;
    }

    public void setStock(List<Item> stock) {
        this.stock = stock;
    }

    @Override
    public String toString(){
        return String.join(", ", this.getClass().getSimpleName(),Integer.toString(id),city);
    }

}
