package com.pausansa.Entity.NPC;

import com.pausansa.Entity.Item.Item;
import com.pausansa.Entity.Item.ItemBuilder;

import java.util.Arrays;
import java.util.List;

public class Thief extends NPC{

    public Thief(String city, ItemBuilder itemBuilder) {
        super(0f,3,0.25f, city,itemBuilder);
        List<Item> initArticles = Arrays.asList(
                this.itemBuilder.build("Bike","Vehicle",65.50f),
                this.itemBuilder.build("Car","Vehicle",4007.50f),
                this.itemBuilder.build("PC","Electronics",900.55f)

        );
        this.stock.addAll(initArticles);
    }

}
