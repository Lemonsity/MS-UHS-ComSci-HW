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
                            Square s = new Square();
                            s.setSide1(side1);
                            storage.add(s);
                            break;
                        case 2:
                            Rectangle r = new Rectangle();
                            r.setSide1(side1);
                            r.setSide2(side2);
                            storage.add(r);
                            break;
                        case 3:
                            Rhombus rh = new Rhombus();
                            rh.setSide1(side1);
                            rh.setHeight(height);
                            storage.add(rh);
                            break;
                        case 4:
                            Parallelogram p = new Parallelogram();
                            p.setSide1(side1);
                            p.setSide2(side2);
                            p.setHeight(height);
                            storage.add(p);
                            break;
                        case 5:
                            Kite k = new Kite();
                            k.setSide1(side1);
                            k.setSide2(side2);
                            k.setDiag1(diag1);
                            k.setDiag2(diag2);
                            storage.add(k);
                            break;
                        case 6:
                            Trapezoid t = new Trapezoid();
                            t.setSide1(side1);
                            t.setSide2(side2);
                            t.setBot(bot);
                            t.setTop(top);
                            t.setHeight(height);
                            storage.add(t);
                            break;
                        case 7:
                            Square sd = new Square();
                            sd.setSide1(1);
                            storage.add(sd);
                            break;
                    }
                case 2:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to remove\n");
                        break;
                    }
                    chooseShape();
                    System.out.print("7. Specific shape with specific characteristic\n");
                    shape = Integer.parseInt(br.readLine());
                    if (shape != 7) {
                        counter = 0;
                        indexExist = new int[20];
                        for (int i = 0; i < 20; i++) {
                            if ((shape == 1 && storage.get(i) instanceof Square)
                                    || (shape == 2 && storage.get(i) instanceof Rectangle)
                                    || (shape == 3 && storage.get(i) instanceof Rhombus)
                                    || (shape == 4 && storage.get(i) instanceof Parallelogram)
                                    || (shape == 5 && storage.get(i) instanceof Kite)
                                    || (shape == 6 && storage.get(i) instanceof Trapezoid)) {
                                System.out.printf("%d. %s\n", counter + 1, storage.get(i).toString());
                                indexExist[counter] = i;
                                counter++;
                            }
                        }
                        System.out.print("Enter the number of the object you want to delete\n");
                        input = Integer.parseInt(br.readLine());
                        storage.get(indexExist[input - 1]).remove();
                        storage.remove(indexExist[input - 1]);
                    }
                    else{
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
                    }
                case 3:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to manipulate\n");
                        break;
                    }
                case 4:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to extract\n");
                        break;
                    }
            }
            choice1();
            input = Integer.parseInt(br.readLine());
        }
        System.out.print("End of program\n");
    }

    public static void choice1() {
        System.out.print("Please choose the action.\n");
        System.out.print("1. Add a shape\n");
        System.out.print("2. Remove a shape\n");
        System.out.print("3. Manipulate one of the shape\n");
        System.out.print("4. Extract info from one shape\n");
        System.out.print("5. Exit the program\n");
    }

    public static void chooseShape() {
        System.out.print("Please choose the shape\n");
        System.out.print("1. Square\n");
        System.out.print("2. Rectangle\n");
        System.out.print("3. Rhombus\n");
        System.out.print("4. Parallelogram\n");
        System.out.print("5. Kite\n");
        System.out.print("6. Trapezoid\n");
    }
}
