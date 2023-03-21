package com.pausansa.Entity.NPC;

import com.pausansa.Entity.Item.Item;
import com.pausansa.Entity.Item.ItemBuilder;

import java.util.Arrays;
import java.util.List;

public class Farmer extends NPC{
    public Farmer(String city,ItemBuilder itemBuilder){
        super(0.02f,5,0.15f,city,itemBuilder);
        List<Item> initArticles = Arrays.asList(
                this.itemBuilder.build("Chair","Forniture",17.50f),
                this.itemBuilder.build("Knife","Kitchen",7.50f),
                this.itemBuilder.build("Mouse","Electronics",9.55f)

        );
        this.stock.addAll(initArticles);
    }



}
