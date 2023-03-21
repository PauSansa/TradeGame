package com.pausansa.Application;

import java.io.*;

public class Serializer {
    public Serializer(){

    }

    public static void write(App app){
        try{
            FileOutputStream fileOut = new FileOutputStream("app.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(app);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static App read() throws Exception{
        App app = null;

        FileInputStream fileIn = new FileInputStream("app.ser");
        ObjectInputStream input = new ObjectInputStream(fileIn);
        app = (App) input.readObject();



        return app;
    }
}
