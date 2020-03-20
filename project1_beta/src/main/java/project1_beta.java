/*
this program accepts a number (0-127)
and gives the binary code of this number
*/

import java.util.Scanner;
import java.lang.String;

public class project1_beta {

    public static Scanner selection= new Scanner(System.in);
    public static int codes=0, do_numbers=0, chyslos=0, do_code=0;
    public static int zero=1, one=10, two=100, three=1000, four=10000, five=100000, six=1000000;

    public static void main(String[] args) {
        clonMain();
    }
    public static void clonMain(){
        boolean game =true;
        byte vybir=0;
        while (game==true){
            promain();
            boolean gamestatus=true;
            while (gamestatus==true){
                System.out.println("please press <<1>> if you want replay or <<0>> if you want end the game");
                System.out.println(vybir);
                vybir=selection.nextByte();
                if (vybir==1){
                    gamestatus=false;
                }
                else if(vybir==0){
                    game =false;
                    System.out.println("gameover");
                    gamestatus=false;
                }
                else {
                    gamestatus=true;
                    System.out.println("error");
                }
            }
        }
    }
    public static void promain(){
        boolean perevirka=false;
        byte znachenya = 0;
        while (perevirka==false){
            System.out.println("please select");
            System.out.println("1-is the creation of binary code");
            System.out.println("2-is the creation of number");
            znachenya=selection.nextByte();
            if (znachenya==1 || znachenya==2 ) {
                perevirka=true;
            }
            else {
                System.out.println("error");
            }
        }

        if(znachenya==1){
            perevirckachysla();
            System.out.println(chyslos);
            creatBinary();
            System.out.println("your binary code is "+do_code);
        }
        else if(znachenya==2){


            perevirkaBinarCode();
            creatNumber();
            System.out.println("your number is "+do_numbers);
        }
    }

    public static void perevirckachysla(){

        boolean q=false;
        while (q==false){
            System.out.println("please write numbe from 0 to 277");
            chyslos=selection.nextInt();
            if (chyslos>=0 && chyslos<=127){
                q=true;
            }
            else {
                System.out.println("error");
            }
        }
    }
    public static void creatBinary(){
        while (chyslos!=0){
            if(chyslos>=64){
                chyslos-=64;
                do_code+=six;
            }
            else if(chyslos>=32){
                chyslos-=32;
                do_code+=five;
            }
            else if(chyslos>=16){
                chyslos-=16;
                do_code+=four;
            }
            else if(chyslos>=8){
                chyslos-=8;
                do_code+=three;
            }
            else if(chyslos>=4){
                chyslos-=4;
                do_code+=two;
            }
            else if(chyslos>=2){
                chyslos-=2;
                do_code+=one;
            }
            else if(chyslos>=1){
                chyslos-=1;
                do_code+=zero;
            }
        }
    }


    public static void perevirkaBinarCode(){

        boolean perevirka=false;
        while (!perevirka) {
            System.out.println("please write binary code");
            String binary = selection.next();
            String[] binar_char=binary.split("");
            boolean perevirka_vnutrisnya = true;
            for (int x=0;x<binary.length();x++) {
                if (binar_char[x].equals("1") || binar_char[x].equals("0")){
                    System.out.print(".");
                }
                else {
                    perevirka_vnutrisnya=false;
                }
            }
            if (perevirka_vnutrisnya==true) {
                perevirka = true;
                codes=Integer.parseInt(binary);
            } else {
                System.out.println("error");
            }
        }

    }
    public static void creatNumber(){

        while(codes!=0){
            if (codes>=six) {
                codes-=six;
                do_numbers+=64;
            }
            else if (codes>=five) {
                codes-=five;
                do_numbers+=32;
            }
            else if (codes>=four) {
                codes-=four;
                do_numbers+=16;
            }
            else if (codes>=three) {
                codes-=three;
                do_numbers+=8;
            }
            else if (codes>=two) {
                codes-=two;
                do_numbers+=4;
            }
            else if (codes>=one) {
                codes-=one;
                do_numbers+=2;
            }
            else{
                codes-=zero;
                do_numbers+=1;
            }
        }
    }

}
