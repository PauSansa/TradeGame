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

    public static App read(){
        App app = null;
        try {
            FileInputStream fileIn = new FileInputStream("app.ser");
            ObjectInputStream input = new ObjectInputStream(fileIn);
            app = (App) input.readObject();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return app;
    }
}
