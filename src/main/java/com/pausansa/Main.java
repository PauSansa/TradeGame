package com.pausansa;

import com.pausansa.Application.App;
import com.pausansa.Application.EntryManager;
import com.pausansa.Application.Serializer;

public class Main {
    public static void main(String[] args) {
        int opt = EntryManager.readInt("Do you wanna restore your session? \n0-No\n1-Yes\nDefault (Yes)");
        if(opt == 0){
            App app = new App();
            app.init();
        } else{
            App app = Serializer.read();
            app.init();
            System.out.println("Break");
        }



    }
}