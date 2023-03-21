package com.pausansa.Entity.Item;

import java.io.Serializable;

public class ItemBuilder implements Serializable {
    private int nItems;

    public Item build(String name, String type,float price){
        return new Item(nItems++, name, type,price);
    }
}
