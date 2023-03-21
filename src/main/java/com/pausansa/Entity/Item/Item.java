package com.pausansa.Entity.Item;

import java.io.Serializable;

public class Item implements Comparable, Serializable {
    private static int numItems = 0;
    private int id;
    private String name;
    private String type;
    private float price;
    private float percentageRusted = 0f;

    public Item(int id,String name, String type,float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }
    @Override
    public String toString(){
        return String.join(", ","#"+id,name,type, price +"€", percentageRusted * 100 +"%");
    }


    @Override
    public int compareTo(Object o) {
        Item other = ((Item) o);

        if(this.price > other.price){
            return 1;
        } else if (this.price < other.price) {
            return -1;
        }else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPercentageRusted() {
        return percentageRusted;
    }

    public void setPercentageRusted(float percentageRusted) {
        this.percentageRusted = percentageRusted;
    }
}
