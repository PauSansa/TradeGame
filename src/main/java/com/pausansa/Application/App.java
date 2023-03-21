package com.pausansa.Application;

import com.pausansa.Entity.Item.Item;
import com.pausansa.Entity.Item.ItemBuilder;
import com.pausansa.Entity.NPC.Farmer;
import com.pausansa.Entity.NPC.Merchant;
import com.pausansa.Entity.NPC.NPC;
import com.pausansa.Entity.NPC.Thief;
import com.pausansa.Exceptions.InventoryFull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App implements Serializable {
    List<NPC> NPCs;
    List<Item> myStock;
    ItemBuilder itemBuilder = new ItemBuilder();
    public App(){
        NPCs = Arrays.asList(
                new Farmer("Barcelona",itemBuilder),
                new Farmer("Mataro",itemBuilder),
                new Thief("Barcelona",itemBuilder),
                new Thief("Argentona",itemBuilder),
                new Merchant("Orrius",itemBuilder),
                new Merchant("Granollers",itemBuilder)
        );
        myStock = new ArrayList<>();
    }

    public void init(){
        loop();
    }

    public void loop(){
        boolean loop = true;
        while(loop){
            byte opt = getOpt();
            switch(opt){
                case 1-> listSellerItems();
                case 2-> listByCity();
                case 3-> listCheapest();
                case 4-> listByType();
                case 5-> simulatePurchase();
                case 6-> simulateSell();
                case 7-> listMyStock();
                case 8-> saveInstance();
                case 9-> loop = false;
            }
        }


    }

    public byte getOpt(){
        System.out.println();
        System.out.println("1- Consult the items of a seller.");
        System.out.println("2- Check the vendors in a city.");
        System.out.println("3- Show the cheapest item from all vendors in a city");
        System.out.println("4- Show all items of a certain type ordered by price (asc) ");
        System.out.println("5- Simulate the purchase of an item from an NPC.");
        System.out.println("6- Simulate the sale of an item to an NPC.");
        System.out.println("7- List my Stock");
        System.out.println("8- Save my game");
        System.out.println("9- Exit");
        return EntryManager.readRestrictedByte("Enter your Option",1,9);
    }

    //Number 1 On loop()
    public void listSellerItems(){
        System.out.println("Current Sellers:");
        NPCs.forEach(System.out::println);
        System.out.println();

        int id = EntryManager.readRestrictedInt("Enter the id of the desired seller",0,(this.NPCs.size()==0 ? 0 : this.NPCs.size()-1));
        NPC npc = NPCs.get(id);
        npc.getStock().forEach(System.out::println);
    }

    //Number 2 On loop()
    public void listByCity(){
        String city = EntryManager.readString("Enter the desired city").toLowerCase();
        NPCs.stream().filter((N) -> N.getCity().toLowerCase().equals(city)).forEach(System.out::println);
    }

    //Number 3 on loop()
    public void listCheapest(){
        for (NPC n : NPCs){
            Item cheapest = n.getStock().stream().sorted().toList().get(0);
            System.out.println("Seller ID: " + n.getId() + " Item: " + cheapest);
        }
        System.out.println("Done");
    }

    //Number 4 on loop()
    public void listByType(){
        List<Item> allStock = new ArrayList<>();
        for(NPC n : NPCs){
            allStock.addAll(n.getStock());
        }

        String type = EntryManager.readString("Enter the desired type").toLowerCase();
        allStock.stream().filter((i)-> i.getType().toLowerCase().equals(type)).forEach(System.out::println);
    }

    //Number 5 on loop()
    public void simulatePurchase(){
        NPCs.forEach(System.out::println);
        int id = EntryManager.readRestrictedInt("Enter the id of the desired seller to purchase",0,(this.NPCs.size()==0 ? 0 : this.NPCs.size()-1));
        NPC npc = NPCs.get(id);

        System.out.println("Available Items:");
        npc.getStock().forEach(System.out::println);

        try{
            int itemId = EntryManager.readInt("Enter the id of the Desired Article");
            Item item = npc.getStock().stream().filter((i) -> i.getId() == itemId).toList().get(0);
            npc.sellItem(item);
            myStock.add(item);
        } catch(IndexOutOfBoundsException e){
            System.out.println("No Item Found");
        }
    }

    //Number 6 on loop()
    public void simulateSell(){
        if(this.myStock.isEmpty()){
            return;
        }

        NPCs.forEach(System.out::println);
        int id = EntryManager.readRestrictedInt("Enter the id of the desired seller to sell",0,(this.NPCs.size()==0 ? 0 : this.NPCs.size()-1));
        NPC npc = NPCs.get(id);

        myStock.forEach(System.out::println);
        try{
            int itemId = EntryManager.readInt("Enter the id of the Desired Article");
            Item item = this.myStock.stream().filter((i) -> i.getId() == itemId).toList().get(0);
            npc.buyItem(item);
            myStock.remove(item);
        } catch(IndexOutOfBoundsException e){
            System.out.println("No Item Found");
        } catch (InventoryFull e){
            System.out.println(e.getMessage());
        }
    }

    //Number 7 in loop()
    public void listMyStock(){
        if(myStock.isEmpty()){
            System.out.println("You dont have any Item \n");
            return;
        }
        myStock.forEach(System.out::println);
    }

    //Number 8 in loop()
    public void saveInstance(){
        Serializer.write(this);
    }
}
