package com.pausansa.Entity.NPC;

import com.pausansa.Entity.Item.Item;
import com.pausansa.Entity.Item.ItemBuilder;

import java.util.Arrays;
import java.util.List;

public class Merchant extends NPC{

    public Merchant(String city, ItemBuilder itemBuilder) {
        super(0.04f, 7, 0f, city,itemBuilder);
        List<Item> initArticles = Arrays.asList(
                this.itemBuilder.build("Phone","Electornics",170.50f),
                this.itemBuilder.build("Airpods","Electornics",90.50f),
                this.itemBuilder.build("Sciccors","Office",9.55f)

        );
        this.stock.addAll(initArticles);
    }


}
