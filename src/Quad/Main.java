package Quad;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Quadrilateral> storage = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int shape;
        int input;
        int counter;
        int[] indexExist;
        //*************** Characteristic *****************
        int side1 = 0;
        int side2 = 0;
        int height = 0;
        int top = 0;
        int bot = 0;
        int diag1 = 0;
        int diag2 = 0;
        //************************************************
        choice1();
        input = Integer.parseInt(br.readLine());
        while (input != 5) {
            switch (input) {
                //********************** Adding a shape **************************
                case 1:
                    if (storage.size() == 20) {
                        System.out.print("Not enough storage\n");
                        break;
                    }
                    chooseShape();
                    System.out.print("7. Default square\n");
                    shape = Integer.parseInt(br.readLine());
                    if (shape != 7)
                        side1 = Integer.parseInt(br.readLine());
                    if (shape == 2 || shape == 4 || shape == 5 || shape == 6)
                        side2 = Integer.parseInt(br.readLine());
                    if (shape == 3 || shape == 4 || shape == 6)
                        height = Integer.parseInt(br.readLine());
                    if (shape == 5) {
                        diag1 = Integer.parseInt(br.readLine());
                        diag2 = Integer.parseInt(br.readLine());
                    }
                    if (shape == 6) {
                        top = Integer.parseInt(br.readLine());
                        bot = Integer.parseInt(br.readLine());
                    }
                    switch (shape) {
                        case 1:
                            Square s = new Square(side1);
                            storage.add(s);
                            break;
                        case 2:
                            Rectangle r = new Rectangle(side1, side2);
                            storage.add(r);
                            break;
                        case 3:
                            Rhombus rh = new Rhombus(side1, height);
                            storage.add(rh);
                            break;
                        case 4:
                            Parallelogram p = new Parallelogram(side1, side2, height);
                            storage.add(p);
                            break;
                        case 5:
                            Kite k = new Kite(side1, side2, diag1, diag2);
                            storage.add(k);
                            break;
                        case 6:
                            Trapezoid t = new Trapezoid(top, bot, height, side1, side2);
                            storage.add(t);
                            break;
                        case 7:
                            Square sd = new Square(1);
                            storage.add(sd);
                            break;
                    }
                    break;
                    //********************** Remove a shape **********************
                case 2:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to remove\n");
                        break;
                    }
                    chooseShape();
                    System.out.print("7. Specific shape with specific characteristic\n");
                    shape = Integer.parseInt(br.readLine());
                    if (shape != 7) {
                        counter = -1;
                        indexExist = new int[20];
                        for (int i = 0; i < storage.size(); i++) {
                            if ((shape == 1 && storage.get(i) instanceof Square)
                                    || (shape == 2 && storage.get(i) instanceof Rectangle)
                                    || (shape == 3 && storage.get(i) instanceof Rhombus)
                                    || (shape == 4 && storage.get(i) instanceof Parallelogram)
                                    || (shape == 5 && storage.get(i) instanceof Kite)
                                    || (shape == 6 && storage.get(i) instanceof Trapezoid)) {
                                counter++;
                                System.out.printf("%d. %s\n", counter + 1, storage.get(i).toString() + "\n");
                                indexExist[counter] = i;
                            }
                        }
                        if (counter >= 0) {
                            System.out.print("Enter the number of the object you want to delete\n");
                            input = Integer.parseInt(br.readLine());
                            storage.get(indexExist[input - 1]).remove();
                            storage.remove(indexExist[input - 1]);
                        }
                        else {
                            System.out.print("No such shape is found\n");
                        }
                    }
                    else {
                        chooseShape();
                        shape = Integer.parseInt(br.readLine());
                        side1 = Integer.parseInt(br.readLine());
                        if (shape == 2 || shape == 4 || shape == 5 || shape == 6)
                            side2 = Integer.parseInt(br.readLine());
                        if (shape == 3 || shape == 4 || shape == 6)
                            height = Integer.parseInt(br.readLine());
                        if (shape == 5) {
                            diag1 = Integer.parseInt(br.readLine());
                            diag2 = Integer.parseInt(br.readLine());
                        }
                        if (shape == 6) {
                            top = Integer.parseInt(br.readLine());
                            bot = Integer.parseInt(br.readLine());
                        }
                        Quadrilateral q;
                        switch (shape){
                            case 1:
                                q = new Square(side1);
                                break;
                            case 2:
                                q = new Rectangle(side1, side2);
                                break;
                            case 3:
                                q = new Rhombus(side1, height);
                                break;
                            case 4:
                                q = new Parallelogram(side1, side2, height);
                                break;
                            case 5:
                                q = new Kite(side1, side2, diag1, diag2);
                                break;
                            default:
                                q = new Trapezoid(top, bot, height, side1, side2);
                                break;
                        }
                        counter = -1;
                        for (int i = 0; i < storage.size(); i++){
                            if (storage.get(i).equals(q)){
                                counter++;
                                System.out.print(i + ". " + storage.get(i).toString() + "\n");
                            }
                        }
                        if (counter >= 0) {
                            System.out.print("Enter the index of the object you want to delete\n");
                            input = Integer.parseInt(br.readLine());
                            storage.get(input).remove();
                            storage.remove(input);
                            q.remove();
                        }
                        else {
                            System.out.print("No such shape is found\n");
                        }
                    }
                    break;
                    //********************** Manipulate **********************
                case 3:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to manipulate\n");
                        break;
                    }
                    for (int i = 0; i < storage.size(); i++) {
                        System.out.print(i + " " + storage.get(i).toString() + "\n");
                    }
                    System.out.print("Please enter the index of the shape you want to manipulate\n");
                    input = Integer.parseInt(br.readLine());
                    System.out.print(input + " " + storage.get(input).toString() + "\n");
                    // Square
                    int input2;
                    int input3;
                    if (storage.get(input).getClass() == Square.class) {
                        System.out.print("What is the new side length?\n");
                        input2 = Integer.parseInt(br.readLine());
                        ((Square)storage.get(input)).setSide1(input2);
                    }
                    // Rectangle
                    else if (storage.get(input).getClass() == Rectangle.class) {
                        System.out.print("What aspect would you like to change?\n");
                        System.out.print("1. Side 1\n");
                        System.out.print("2. Side 2\n");
                        input2 = Integer.parseInt(br.readLine());
                        System.out.print("Enter the new value: \n");
                        input3 = Integer.parseInt(br.readLine());
                        switch (input2){
                            case 1:
                                ((Rectangle)storage.get(input)).setSide1(input3);
                            case 2:
                                ((Rectangle)storage.get(input)).setSide2(input3);
                        }
                    }
                    // Rhombus
                    else if (storage.get(input).getClass() == Rhombus.class) {
                        System.out.print("What aspect would you like to change?\n");
                        System.out.print("1. Side 1\n");
                        System.out.print("2. Height\n");
                        input2 = Integer.parseInt(br.readLine());
                        System.out.print("Enter the new value: \n");
                        input3 = Integer.parseInt(br.readLine());
                        switch (input2){
                            case 1:
                                ((Rhombus)storage.get(input)).setSide1(input3);
                            case 2:
                                ((Rhombus)storage.get(input)).setHeight(input3);
                        }
                    }
                    // Parallelogram
                    else if (storage.get(input).getClass() == Parallelogram.class) {
                        System.out.print("What aspect would you like to change?\n");
                        System.out.print("1. Side 1\n");
                        System.out.print("2. Side 2\n");
                        System.out.print("3. Height\n");
                        input2 = Integer.parseInt(br.readLine());
                        System.out.print("Enter the new value: \n");
                        input3 = Integer.parseInt(br.readLine());
                        switch (input2){
                            case 1:
                                ((Parallelogram)storage.get(input)).setSide1(input3);
                            case 2:
                                ((Parallelogram)storage.get(input)).setSide2(input3);
                            case 3:
                                ((Parallelogram)storage.get(input)).setHeight(input3);
                        }
                    }
                    // Kite
                    else if (storage.get(input).getClass() == Kite.class) {
                        System.out.print("What aspect would you like to change?\n");
                        System.out.print("1. Side 1\n");
                        System.out.print("2. Side 2\n");
                        System.out.print("3. Diagonal 1\n");
                        System.out.print("4. Diagonal 2\n");
                        input2 = Integer.parseInt(br.readLine());
                        System.out.print("Enter the new value: \n");
                        input3 = Integer.parseInt(br.readLine());
                        switch (input2){
                            case 1:
                                ((Kite)storage.get(input)).setSide1(input3);
                            case 2:
                                ((Kite)storage.get(input)).setSide2(input3);
                            case 3:
                                ((Kite)storage.get(input)).setDiag1(input3);
                            case 4:
                                ((Kite)storage.get(input)).setDiag2(input3);
                        }
                    }
                    // Trapezoid
                    else {
                        System.out.print("What aspect would you like to change?\n");
                        System.out.print("1. Side 1\n");
                        System.out.print("2. Side 2\n");
                        System.out.print("3. Top\n");
                        System.out.print("4. Bottom\n");
                        System.out.print("5. Height\n");
                        input2 = Integer.parseInt(br.readLine());
                        System.out.print("Enter the new value: \n");
                        input3 = Integer.parseInt(br.readLine());
                        switch (input2){
                            case 1:
                                ((Trapezoid)storage.get(input)).setSide1(input3);
                            case 2:
                                ((Trapezoid)storage.get(input)).setSide2(input3);
                            case 3:
                                ((Trapezoid)storage.get(input)).setTop(input3);
                            case 4:
                                ((Trapezoid)storage.get(input)).setBot(input3);
                            case 5:
                                ((Trapezoid)storage.get(input)).setHeight(input3);
                        }
                    }
                    break;
                    //********************** Extract **********************
                case 4:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to extract\n");
                        break;
                    }
                    break;
            }
            choice1();
            input = Integer.parseInt(br.readLine());
        }
        System.out.print("End of program\n");
    }

    private static void choice1() {
        System.out.print("************************************************************");
        System.out.print("Please choose the action.\n");
        System.out.print("1. Add a shape\n");
        System.out.print("2. Remove a shape\n");
        System.out.print("3. Manipulate one of the shape\n");
        System.out.print("4. Extract info from one shape\n");
        System.out.print("5. Exit the program\n");
    }

    private static void chooseShape() {
        System.out.print("Please choose the shape\n");
        System.out.print("1. Square\n");
        System.out.print("2. Rectangle\n");
        System.out.print("3. Rhombus\n");
        System.out.print("4. Parallelogram\n");
        System.out.print("5. Kite\n");
        System.out.print("6. Trapezoid\n");
    }
}
