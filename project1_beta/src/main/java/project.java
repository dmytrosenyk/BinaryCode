import java.util.Scanner;
import java.lang.String;

public class project1_beta {

    public static Scanner selection= new Scanner(System.in);
    public static int codes=0, do_numbers=0, chyslos=0, do_code=0;

    public static int zero=1, one=10, two=100, three=1000, four=10000, five=100000, six=1000000;
    public static byte vybir=0;
    public static boolean perevirka_vnutrishnya=true , perevirka=false;
    public static void main(String[] args) {
        clonMain();
    }

    public static void clonMain(){
        perevirka =true;
        vybir=0;
        while (perevirka==true){
            promain();
            perevirka_vnutrishnya=true;
            while (perevirka_vnutrishnya==true){
                System.out.println("please press <<1>> if you want replay or <<0>> if you want end the game");
                vybir=selection.nextByte();
                if (vybir==1){
                    perevirka_vnutrishnya=false;
                }
                else if(vybir==0){
                    perevirka =false;
                    System.out.println("gameover");
                    perevirka_vnutrishnya=false;
                }
                else {
                    perevirka_vnutrishnya=true;
                    System.out.println("error");
                }
            }
        }
    }
    public static void promain(){
        perevirka=false;
        vybir = 0;
        while (perevirka==false){
            System.out.println("please select");
            System.out.println("1-is the creation of binary code");
            System.out.println("2-is the creation of number");
            vybir=selection.nextByte();
            if (vybir==1 || vybir==2 ) {
                perevirka=true;
            }
            else {
                System.out.println("error");
            }
        }

        if(vybir==1){
            perevirckachysla();
            creatBinary();
            System.out.println("your binary code is "+do_code);
        }
        else if(vybir==2){


            perevirkaBinarCode();
            creatNumber();
            System.out.println("your number is "+do_numbers);
        }
    }

    public static void perevirckachysla(){

        perevirka=false;
        while (perevirka==false){
            System.out.println("please write numbe from 0 to 277");
            chyslos=selection.nextInt();
            if (chyslos>=0 && chyslos<=127){
                perevirka=true;
            }
            else {
                System.out.println("error");
            }
        }
    }

    public static void perevirkaBinarCode(){

        perevirka=false;
        while (!perevirka) {
            System.out.println("please write binary code");
            String binary = selection.next();
            String[] binar_char=binary.split("");
            perevirka_vnutrishnya = true;
            for (int x=0;x<binary.length();x++) {
                if (binar_char[x].equals("1") || binar_char[x].equals("0")){
                    System.out.print(".");
                }
                else {
                    perevirka_vnutrishnya=false;
                }
            }
            if (perevirka_vnutrishnya==true) {
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
}
