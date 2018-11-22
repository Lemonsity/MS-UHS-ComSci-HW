package Quad;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Quadrilateral> storage = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        choice1();
        int input = Integer.parseInt(br.readLine());
        while (input != 5){
            switch (input){
                case 1:
                    if (storage.size() == 20){
                        System.out.print("Not enough storage\n");
                        break;
                    }
                    chooseShape();
                    int shape = Integer.parseInt(br.readLine());
                    switch (shape){
                        case 1:
                    }
            }
        }
        System.out.print("End of program\n");
    }
    public static void choice1(){
        System.out.print("Please choose the action.\n");
        System.out.print("1. Add a shape\n");
        System.out.print("2. Remove a shape\n");
        System.out.print("3. Manipulate one of the shape\n");
        System.out.print("4. Extract info from one shape\n");
        System.out.print("5. Exit the program\n");

    }
    public static void chooseShape(){
        System.out.print("Please choose the shape\n");
        System.out.print("1. Square\n");
        System.out.print("2. Rectangle\n");
        System.out.print("3. Rhombus\n");
        System.out.print("4. Parallelogram\n");
        System.out.print("5. Kite\n");
        System.out.print("6. Trapezoid\n");
        System.out.print("7. Defualt square\n");
    }
}
