package com.pausansa.Application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntryManager {
    private static Scanner sc = new Scanner(System.in);

    public static String readString(String msg){
        System.out.println(msg+"\n");
        return sc.nextLine();
    }

    public static float readFloat(String msg){
        System.out.println(msg+"\n");
        boolean correct = false;
        float rspns = 0;
        while(!correct){
            try{
                rspns = sc.nextFloat();
                correct = true;
            }catch (InputMismatchException e){
                System.out.println("You must enter a Float, ej: 7,20");
            }
        }
        sc.nextLine();
        return rspns;
    }

    public static byte readRestrictedByte(String msg, int min, int max){
        System.out.println(msg+"\n");
        boolean correct = false;
        byte rspns = 0;
        while(!correct){
            try{
                rspns = sc.nextByte();
                if(min > rspns || rspns > max){
                    throw new InputMismatchException();
                }
                correct = true;
            }catch (InputMismatchException e){
                System.out.println("You must enter a Byte between " + min + " and "+ max);
                sc.nextLine();
            }
        }
        sc.nextLine();
        return rspns;
    }

    public static int readRestrictedInt(String msg, int min, int max){
        System.out.println(msg+"\n");
        boolean correct = false;
        int rspns = 0;
        while(!correct){
            try{
                rspns = sc.nextInt();
                if(min > rspns || rspns > max){
                    throw new InputMismatchException();
                }
                correct = true;
            }catch (InputMismatchException e){
                System.out.println("You must enter a Integer between " + min + " and "+ max);
            }
        }
        sc.nextLine();
        return rspns;
    }

    public static int readInt(String msg){
        System.out.println(msg+"\n");
        boolean correct = false;
        int rspns = 0;
        while(!correct){
            try{
                rspns = sc.nextInt();
                correct = true;
            }catch (InputMismatchException e){
                System.out.println("You must enter a Integer, ej: 7");
            }
        }
        sc.nextLine();
        return rspns;
    }
}
