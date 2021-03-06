package Quad;

import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Quadrilateral> storage = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int shape;
        // There are 3 input variable, mainly for manipulation and extraction
        int input; // Primary input, use to track the index of the shape when user choose
        int input2; // After choosing the index of the shape, the second option: What characteristic they want to change / What characeristic they want to know
        int input3; // What the user want to characteristic to be changed into
        String stringInput = "";
        int counter;
        int index_real;
        //*************** Characteristic *****************
        int side1 = 0;
        int side2 = 0;
        int height = 0;
        int top = 0;
        int bot = 0;
        int diag1 = 0;
        int diag2 = 0;
        //******************* Shapes *********************
        Quadrilateral q;
        Square s;
        Rectangle r;
        Rhombus rh;
        Parallelogram p;
        Kite k;
        Trapezoid t;
        choice1();
        input = Integer.parseInt(br.readLine());
        while (input != 6) {
            switch (input) {
                //********************** Adding a shape ********************************************************************************************
                case 1:
                    if (storage.size() == 20) {
                        System.out.print("************************************************************\n");
                        System.out.print("Not enough storage\n");
                        break;
                    }
                    System.out.print("************************************************************\n");
                    chooseShape();
                    shape = Integer.parseInt(br.readLine());
                    System.out.print("************************************************************\n");
                    System.out.print("Would you like to create a default shape or custom shape?\n");
                    System.out.print("1. Default\n");
                    System.out.print("2. Custom\n");
                    input = Integer.parseInt(br.readLine());
                    if (input == 1) {
                        switch (shape) {
                            case 1:
                                s = new Square();
                                storage.add(s);
                                break;
                            case 2:
                                r = new Rectangle();
                                storage.add(r);
                                break;
                            case 3:
                                rh = new Rhombus();
                                storage.add(rh);
                                break;
                            case 4:
                                p = new Parallelogram();
                                storage.add(p);
                                break;
                            case 5:
                                k = new Kite();
                                storage.add(k);
                                break;
                            case 6:
                                t = new Trapezoid();
                                storage.add(t);
                                break;
                        }
                    }
                    else if (input == 2) {
                        do {
                            if (shape != 7) {
                                System.out.print("Please enter the length of side 1 (The length of the left slope if it's trapezoid):\n");
                                side1 = Integer.parseInt(br.readLine());
                            }
                            if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                                System.out.print("Please enter the length of side 2 (The length of the right slope if it's trapezoid):\n");
                                side2 = Integer.parseInt(br.readLine());
                            }
                            if (shape == 3 || shape == 4 || shape == 6) {
                                System.out.print("Please enter the height:\n");
                                height = Integer.parseInt(br.readLine());
                            }
                            if (shape == 5) {
                                System.out.print("Please enter length of diagonal 1:\n");
                                diag1 = Integer.parseInt(br.readLine());
                                System.out.print("Please enter length of diagonal 2:\n");
                                diag2 = Integer.parseInt(br.readLine());
                            }
                            if (shape == 6) {
                                System.out.print("Please enter length of top:\n");
                                top = Integer.parseInt(br.readLine());
                                System.out.print("Please enter length of bottom:\n");
                                bot = Integer.parseInt(br.readLine());
                            }
                            switch (shape) {
                                case 1:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d\n", side1);
                                    break;
                                case 2:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d, Side 2: %d\n", side1, side2);
                                    break;
                                case 3:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d, Height: %d\n", side1, height);
                                    break;
                                case 4:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d, Side 2: %d, Height: %d\n", side1, side2, height);
                                    break;
                                case 5:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d, Side 2: %d, Diagonal 1: %d, Diagonal 2: %d\n", side1, side2, diag1, diag2);
                                    break;
                                case 6:
                                    System.out.print("************************************************************\n");
                                    System.out.printf("Side 1: %d, Side 2: %d, Height: %d, Top: %d, Base: %d\n", side1, side2, height, top, bot);
                                    break;
                            }
                            if (shape != 7) {
                                System.out.print("Enter Y if the attribute is what you want. Or anything else if you want ot reenter\n");
                                stringInput = br.readLine();
                            }
                        } while (shape != 7 && !stringInput.equalsIgnoreCase("Y"));
                        switch (shape) {
                            case 1:
                                s = new Square(side1);
                                storage.add(s);
                                break;
                            case 2:
                                r = new Rectangle(side1, side2);
                                storage.add(r);
                                break;
                            case 3:
                                rh = new Rhombus(side1, height);
                                storage.add(rh);
                                break;
                            case 4:
                                p = new Parallelogram(side1, side2, height);
                                storage.add(p);
                                break;
                            case 5:
                                k = new Kite(side1, side2, diag1, diag2);
                                storage.add(k);
                                break;
                            case 6:
                                t = new Trapezoid(top, bot, height, side1, side2);
                                storage.add(t);
                                break;
                        }
                    }
                    break;
                //********************** Remove a shape ****************************************************************************************
                case 2:
                    if (storage.size() == 0) {
                        System.out.print("************************************************************\n");
                        System.out.print("Nothing to remove\n");
                        break;
                    }
                    System.out.print("************************************************************\n");
                    chooseShape();
                    System.out.print("7. Specific shape with specific characteristic\n");
                    shape = Integer.parseInt(br.readLine());
                    if (shape != 7) {
                        counter = 0;
                        for (int i = 0; i < storage.size(); i++) {
                            if ((shape == 1 && storage.get(i).getClass() == Square.class)
                                    || (shape == 2 && storage.get(i).getClass() == Rectangle.class)
                                    || (shape == 3 && storage.get(i).getClass() ==  Rhombus.class)
                                    || (shape == 4 && storage.get(i).getClass() ==  Parallelogram.class)
                                    || (shape == 5 && storage.get(i).getClass() ==  Kite.class)
                                    || (shape == 6 && storage.get(i).getClass() ==  Trapezoid.class)) {
                                counter++;
                                System.out.printf("%d. %s\n", i + 1, storage.get(i).toString());
                            }
                        }
                        if (counter > 0) {
                            System.out.print("************************************************************\n");
                            System.out.print("Enter the index of the object you want to delete\n");
                            input = Integer.parseInt(br.readLine());
                            index_real = input - 1;
                            storage.get(index_real).remove();
                            storage.remove(index_real);
                        } else {
                            System.out.print("************************************************************\n");
                            System.out.print("No such shape is found\n");
                        }
                    } else { // user choose to check of these is a specific shape in the database
                        chooseShape();
                        shape = Integer.parseInt(br.readLine());
                        System.out.print("Please enter the length of side 1 (The length of the left slope if it's trapezoid):\n");
                        side1 = Integer.parseInt(br.readLine());
                        if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                            System.out.print("Please enter the length of side 2 (The length of the left slope if it's trapezoid):\n");
                            side2 = Integer.parseInt(br.readLine());
                        }
                        if (shape == 3 || shape == 4 || shape == 6) {
                            System.out.print("Please enter the height:\n");
                            height = Integer.parseInt(br.readLine());
                        }
                        if (shape == 5) {
                            System.out.print("Please enter the length of diagonal 1:\n");
                            diag1 = Integer.parseInt(br.readLine());
                            System.out.print("Please enter the length of diagonal 2:\n");
                            diag2 = Integer.parseInt(br.readLine());
                        }
                        if (shape == 6) {
                            System.out.print("Please enter the length of top:\n");
                            top = Integer.parseInt(br.readLine());
                            System.out.print("Please enter the length of bottom:\n");
                            bot = Integer.parseInt(br.readLine());
                        }
                        switch (shape) {
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
                        counter = 0;
                        for (int i = 0; i < storage.size(); i++) {
                            if (storage.get(i).equals(q)) {
                                counter++;
                                System.out.printf("%d. %s\n", i + 1, storage.get(i).toString());
                            }
                        }
                        if (counter > 0) {
                            System.out.print("Enter the index of the object you want to delete\n");
                            input = Integer.parseInt(br.readLine());
                            index_real = input - 1;
                            storage.get(index_real).remove();
                            storage.remove(index_real);
                        } else {
                            System.out.print("No such shape is found\n");
                        }
                        q.remove();
                    }
                    break;
                //********************** Manipulate ****************************************************************************************
                case 3:
                    if (storage.size() == 0) {
                        System.out.print("************************************************************\n");
                        System.out.print("Nothing to manipulate\n");
                        break;
                    }
                    System.out.print("************************************************************\n");
                    for (int i = 0; i < storage.size(); i++) { // printing out the entire list of databse
                        System.out.printf("%d. ", i + 1);
                        if (storage.get(i).getClass() == Square.class)
                            System.out.print("Square\n");
                        else if (storage.get(i).getClass() == Rectangle.class)
                            System.out.print("Rectangle\n");
                        else if (storage.get(i).getClass() == Rhombus.class)
                            System.out.print("Rhombus\n");
                        else if (storage.get(i).getClass() == Parallelogram.class)
                            System.out.print("Parallelogram\n");
                        else if (storage.get(i).getClass() == Kite.class)
                            System.out.print("Kite\n");
                        else
                            System.out.print("Trapezoid\n");
                    }
                    //****************************************************************************************
                    System.out.print("Please enter the index of the shape you want to manipulate\n");
                    input = Integer.parseInt(br.readLine());
                    index_real = input - 1;
                    System.out.print(input + ". " + storage.get(index_real).toString() + "\n");
                    System.out.print("What aspect would you like to change?\n");
                    System.out.print("1. Side 1\n");
                    if (storage.get(index_real).getClass() == Rectangle.class
                            || storage.get(index_real).getClass() == Parallelogram.class
                            || storage.get(index_real).getClass() == Kite.class
                            || storage.get(index_real).getClass() == Trapezoid.class)
                        System.out.print("2. Side 2\n");
                    if (storage.get(index_real).getClass() == Rhombus.class)
                        System.out.print("2. Height\n");
                    if (storage.get(index_real).getClass() == Parallelogram.class
                            || storage.get(index_real).getClass() == Trapezoid.class)
                        System.out.print("3. Height\n");
                    if (storage.get(index_real).getClass() == Kite.class) {
                        System.out.print("3. Diagonal 1\n");
                        System.out.print("4. Diagonal 2\n");
                    }
                    if (storage.get(index_real).getClass() == Trapezoid.class) {
                        System.out.print("4. Top\n");
                        System.out.print("5. Base\n");
                    }
                    input2 = Integer.parseInt(br.readLine());
                    System.out.print("************************************************************\n");
                    System.out.print("What is the new value?\n");
                    input3 = Integer.parseInt(br.readLine());
                    if (storage.get(index_real).getClass() == Square.class) {
                        switch (input2) {
                            case 1:
                                ((Square)storage.get(index_real)).setSide1(input3);
                                break;
                        }
                    }
                    else if (storage.get(index_real).getClass() == Rectangle.class) {
                        switch (input2) {
                            case 1:
                                ((Rectangle) storage.get(index_real)).setSide1(input3);
                                break;
                            case 2:
                                ((Rectangle) storage.get(index_real)).setSide2(input3);
                                break;
                        }
                    }
                    else if (storage.get(index_real).getClass() == Rhombus.class) {
                        switch (input2) {
                            case 1:
                                ((Rhombus) storage.get(index_real)).setSide1(input3);
                                break;
                            case 2:
                                ((Rhombus) storage.get(index_real)).setHeight(input3);
                                break;
                        }
                    }
                    else if (storage.get(index_real).getClass() == Parallelogram.class) {
                        switch (input2) {
                            case 1:
                                ((Parallelogram) storage.get(index_real)).setSide1(input3);
                                break;
                            case 2:
                                ((Parallelogram) storage.get(index_real)).setSide2(input3);
                                break;
                            case 3:
                                ((Parallelogram) storage.get(index_real)).setHeight(input3);
                                break;
                        }
                    }
                    else if (storage.get(index_real).getClass() == Kite.class) {
                        switch (input2) {
                            case 1:
                                ((Kite) storage.get(index_real)).setSide1(input3);
                                break;
                            case 2:
                                ((Kite) storage.get(index_real)).setSide2(input3);
                                break;
                            case 3:
                                ((Kite) storage.get(index_real)).setDiag1(input3);
                                break;
                            case 4:
                                ((Kite) storage.get(index_real)).setDiag2(input3);
                                break;
                        }
                    }
                    else {
                        switch (input2) {
                            case 1:
                                ((Trapezoid) storage.get(index_real)).setSide1(input3);
                                break;
                            case 2:
                                ((Trapezoid) storage.get(index_real)).setSide2(input3);
                                break;
                            case 3:
                                ((Trapezoid) storage.get(index_real)).setHeight(input3);
                                break;
                            case 4:
                                ((Trapezoid) storage.get(index_real)).setTop(input3);
                                break;
                            case 5:
                                ((Trapezoid) storage.get(index_real)).setBot(input3);
                                break;
                        }
                    }
                    break;
                //********************** Extract **************************************************************************************************************
                case 4:
                    if (storage.size() == 0) {
                        System.out.print("************************************************************\n");
                        System.out.print("Nothing to extract\n");
                        break;
                    }
                    System.out.print("************************************************************\n");
                    for (int i = 0; i < storage.size(); i++) {
                        System.out.printf("%d. ", i + 1);
                        if (storage.get(i).getClass() == Square.class)
                            System.out.print("Square\n");
                        else if (storage.get(i).getClass() == Rectangle.class)
                            System.out.print("Rectangle\n");
                        else if (storage.get(i).getClass() == Rhombus.class)
                            System.out.print("Rhombus\n");
                        else if (storage.get(i).getClass() == Parallelogram.class)
                            System.out.print("Parallelogram\n");
                        else if (storage.get(i).getClass() == Kite.class)
                            System.out.print("Kite\n");
                        else
                            System.out.print("Trapezoid\n");
                    }
                    index_real = -1;
                    System.out.print("************************************************************\n");
                    System.out.print("Do you want to search by index or by key?\n");
                    System.out.print("1. Index\n");
                    System.out.print("2. Key\n");
                    input = Integer.parseInt(br.readLine());
                    if (input == 1) {
                        System.out.print("************************************************************\n");
                        System.out.print("Enter the index of the shape you want to extract:\n");
                        input = Integer.parseInt(br.readLine()); // The index of the shape the user want to access
                        index_real = input - 1;
                    }
                    else {
                        System.out.print("************************************************************\n");
                        System.out.print("Please enter the key \n(Shape type followed by a number with space in between)\n");
                        stringInput = br.readLine();
                        boolean check = false;
                        for (int i = 0; i < storage.size(); i++){
                            if (storage.get(i).getKey().equalsIgnoreCase(stringInput)) {
                                check = true;
                                index_real = i;
                                System.out.print("Shape found\n");
                                break;
                            }
                        }
                        if (!check) {
                            System.out.print("No shape with such key is found\n");
                            break;
                        }
                    }
                    //---------------------------------------------------------------------------------------------
                    System.out.print("************************************************************\n");
                    System.out.print("What would you like to know about this shape?\n");
                    System.out.print("1. Amount of total Quadrilateral\n");
                    System.out.print("2. Amount of such shape selected\n");
                    System.out.print("3. Area of the shape\n");
                    System.out.print("4. Parameter of the shape\n");
                    //********************** Square **********************
                    if (storage.get(index_real).getClass() == Square.class) {
                        System.out.print("5. Side 1\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Square.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Square)storage.get(index_real)).getSide1());
                                break;
                        }
                    }
                    //********************** Rectangle **********************
                    else if (storage.get(index_real).getClass() == Rectangle.class) {
                        System.out.print("5. Side 1\n");
                        System.out.print("6. Side 2\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Rectangle.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Rectangle)storage.get(index_real)).getSide1());
                                break;
                            case 6:
                                System.out.printf("Side 2: %d\n", ((Rectangle)storage.get(index_real)).getSide2());
                                break;
                        }
                    }
                    //********************** Rhombus **********************
                    else if (storage.get(index_real).getClass() == Rhombus.class) {
                        System.out.print("5. Side 1\n");
                        System.out.print("6. Height\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Rhombus.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Rhombus)storage.get(index_real)).getSide1());
                                break;
                            case 6:
                                System.out.printf("Height: %d\n", ((Rhombus)storage.get(index_real)).getHeight());
                                break;
                        }

                    }
                    //********************** Parallelogram **********************
                    else if (storage.get(index_real).getClass() == Parallelogram.class) {
                        System.out.print("5. Side 1\n");
                        System.out.print("6. Side 2\n");
                        System.out.print("7. Height\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Parallelogram.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Parallelogram)storage.get(index_real)).getSide1());
                                break;
                            case 6:
                                System.out.printf("Side 2: %d\n", ((Parallelogram)storage.get(index_real)).getSide2());
                                break;
                            case 7:
                                System.out.printf("Height: %d\n", ((Parallelogram)storage.get(index_real)).getHeight());
                                break;
                        }
                    }
                    //********************** Kite **********************
                    else if (storage.get(index_real).getClass() == Kite.class) {
                        System.out.print("5. Side 1\n");
                        System.out.print("6. Side 2\n");
                        System.out.print("7. Diagonal 1\n");
                        System.out.print("8. Diagonal 2\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Kite.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Kite)storage.get(index_real)).getSide1());
                                break;
                            case 6:
                                System.out.printf("Side 2: %d\n", ((Kite)storage.get(index_real)).getSide2());
                                break;
                            case 7:
                                System.out.printf("Diagonal 1: %d\n", ((Kite)storage.get(index_real)).getDiag1());
                                break;
                            case 8:
                                System.out.printf("Diagonal 2: %d\n", ((Kite)storage.get(index_real)).getDiag2());
                                break;
                        }
                    }
                    //********************** Trapezoid **********************
                    else {
                        System.out.print("5. Side 1\n");
                        System.out.print("6. Side 2\n");
                        System.out.print("7. Top\n");
                        System.out.print("8. Bottom\n");
                        System.out.print("9. Height\n");
                        System.out.print("************************************************************\n");
                        input2 = Integer.parseInt(br.readLine());
                        switch (input2) {
                            case 1:
                                System.out.printf("There are %d quadrilateral in total\n", storage.get(index_real).getQuadNum());
                                break;
                            case 2:
                                System.out.printf("There are %d such shape\n", Trapezoid.getNum());
                                break;
                            case 3:
                                System.out.printf("The area is %d\n", storage.get(index_real).findArea());
                                break;
                            case 4:
                                System.out.printf("The parameter is %d\n", storage.get(index_real).findParameter());
                                break;
                            case 5:
                                System.out.printf("Side 1: %d\n", ((Trapezoid)storage.get(index_real)).getSide1());
                                break;
                            case 6:
                                System.out.printf("Side 2: %d\n", ((Trapezoid)storage.get(index_real)).getSide2());
                                break;
                            case 7:
                                System.out.printf("Top: %d\n", ((Trapezoid)storage.get(index_real)).getTop());
                                break;
                            case 8:
                                System.out.printf("Bottom: %d\n", ((Trapezoid)storage.get(index_real)).getBot());
                                break;
                            case 9:
                                System.out.printf("Height: %d\n", ((Trapezoid)storage.get(index_real)).getHeight());
                                break;
                        }
                    }
                    //--------------------------------------------------------------------------------------
                    break;
                case 5:
                    if (storage.size() == 0) {
                        System.out.print("Nothing to show\n");
                    }
                    for (int i = 0; i < storage.size(); i++)
                        System.out.print(storage.get(i).toString() + "\n");
                    break;
            }
            choice1();
            input = Integer.parseInt(br.readLine());
        }
        System.out.print("************************************************************\n");
        System.out.print("End of program\n");
    }
    private static void choice1() {
        System.out.print("************************************************************\n");
        System.out.print("Please choose the action.\n");
        System.out.print("1. Add a shape\n");
        System.out.print("2. Remove a shape\n");
        System.out.print("3. Manipulate one of the shape\n");
        System.out.print("4. Extract info from one shape\n");
        System.out.print("5. List all shapes\n");
        System.out.print("6. Exit the program\n");
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
