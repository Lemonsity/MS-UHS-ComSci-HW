package Quad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//This is a class that help me test feature of the Java language and other class specific functions
public class MainNewVersion {

    private static List<Quadrilateral> database = new ArrayList<>(); // database

    public static void main(String[] args) throws IOException {
        int choice; // Choice made in main menu
        int index;
        mainMenu();
        choice = Integer.parseInt(input());
        while (choice != 5) { // if user doesn't choose to end program (5)
            switch (choice) {
                case 1:
                    if (checkFull()) {
                        shapeMenu();
                        shapeInitial(Integer.parseInt(input()));
                    }
                    else {
                        separator();
                        System.out.print("Not enough storage\n");
                    }
                    break;
                case 2:
                    if (!checkEmpty()) {
                        indexKeyCharacteristicMenu();
                        choice = Integer.parseInt(input());
                        if (choice == 1)
                            index = searchByIndex();
                        else if (choice == 2)
                            index = searchByKey();
                        else
                            index = searchByCharacteristic();
                        removeShape(index);
                    }
                    else {
                        separator();
                        System.out.print("There is no shape to remove\n");
                    }
                    break;
                case 3:
                    if (!checkEmpty()) {
                        indexKeyCharacteristicMenu();
                        choice = Integer.parseInt(input());
                        if (choice == 1)
                            index = searchByIndex();
                        else if (choice == 2)
                            index = searchByKey();
                        else
                            index = searchByCharacteristic();
                        chooseActionToShape(index);
                    }
                    else {
                        separator();
                        System.out.print("There is no shape to choose from\n");
                    }
                    break;
                case 4:
                    list();
                    break;
            }
            mainMenu();
            choice = Integer.parseInt(input());
        }
        end(); // End of program
    }

    private static void shapeInitial(int shape) throws IOException{
        separator();
        System.out.print("You are about to create a ");
        switch (shape) {
            case 1:
                System.out.print("Square\n");
                break;
            case 2:
                System.out.print("Rectangle\n");
                break;
            case 3:
                System.out.print("Rhombus\n");
                break;
            case 4:
                System.out.print("Parallelogram\n");
                break;
            case 5:
                System.out.print("Kite\n");
                break;
            case 6:
                System.out.print("Trapezoid\n");
                break;
        }
        System.out.print("Would you like to create a default of such shape or custom one?\n");
        System.out.print("1. Default\n");
        System.out.print("2. Custom\n");
        int choiceDC = Integer.parseInt(input()); // DC stands for Default / Custom, the choice user made
        if (choiceDC == 1)
            database.add(defaultShape(shape));
        else
            database.add(customShape(shape));
        System.out.print(database.get(database.size() - 1).toString() + "\n");
    }
    private static Quadrilateral defaultShape(int shape) {
        switch (shape) {
            case 1:
                return new Square();
            case 2:
                return new Rectangle();
            case 3:
                return new Rhombus();
            case 4:
                return new Parallelogram();
            case 5:
                return new Kite();
            default:
                return new Trapezoid();
        }
    }
    private static Quadrilateral customShape(int shape) throws IOException{
        String reenter;
        double side1, side2 = 0, height = 0, diag1 = 0, diag2 = 0, top = 0, bot = 0; // Shape characteristic
        do {
            separator();
            System.out.print("Please enter the length of side 1 (The length of the left slope if it's trapezoid):\n");
            side1 = Double.parseDouble(input());
            if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                System.out.print("Please enter the length of side 2 (The length of the right slope if it's trapezoid):\n");
                side2 = Double.parseDouble(input());
            }
            if (shape == 3 || shape == 4 || shape == 6) {
                System.out.print("Please enter the height:\n");
                height = Double.parseDouble(input());
            }
            if (shape == 5) {
                System.out.print("Please enter length of diagonal 1:\n");
                diag1 = Double.parseDouble(input());
                System.out.print("Please enter length of diagonal 2:\n");
                diag2 = Double.parseDouble(input());
            }
            if (shape == 6) {
                System.out.print("Please enter length of top:\n");
                top = Double.parseDouble(input());
                System.out.print("Please enter length of bottom:\n");
                bot = Double.parseDouble(input());
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            separator();
            System.out.printf("Side 1: %f, ", side1);
            if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                System.out.printf("Side 2: %f, ", side2);
            }
            if (shape == 3 || shape == 4 || shape == 6) {
                System.out.printf("Side height: %f, ", height);
            }
            if (shape == 5) {
                System.out.printf("Diagonal 1: %f, ", diag1);
                System.out.printf("Diagonal 2: %f, ", diag2);

            }
            if (shape == 6) {
                System.out.printf("Top: %f, ", top);
                System.out.printf("Base: %f, ", bot);
            }
            System.out.print("\nEnter 'Y' if you are satisfied with the characteristic\n");
            System.out.print("Enter anything else if you want to reenter\n");
            reenter = input();
        } while (!reenter.equalsIgnoreCase("Y"));
        switch (shape) {
            case 1:
                return new Square(side1);
            case 2:
                return new Rectangle(side1, side2);
            case 3:
                return new Rhombus(side1, height);
            case 4:
                return new Parallelogram(side1, side2, height);
            case 5:
                return new Kite(side1, side2, diag1, diag2);
            default:
                return new Trapezoid(top, bot, height, side1, side2);
        }
    }

    private static int searchByIndex() throws IOException{
        separator();
        for (int i = 0; i < database.size(); i++)
            System.out.print((i + 1) + " " + database.get(i).getClassName() + "\n");
        separator();
        System.out.print("Please enter the index of the shape\n");
        return Integer.parseInt(input()) - 1;
    }
    private static int searchByKey() throws IOException{
        int index = -1;
        String key;
        separator();
        System.out.print("Please enter the key (Shape type followed by a number with space in between)\nExample: Square 5\n");
        key = input();
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).getKey().equalsIgnoreCase(key)){
                index = i;
                break;
            }
        }
        return index;
    }
    private static int searchByCharacteristic() throws IOException {
        int index = -1;
        shapeMenu();
        Quadrilateral check = customShape(Integer.parseInt(input()));
        for (int i = 0; i < database.size(); i++) {
            if (database.get(i).equals(check)) {
                index = i;
                break;
            }
        }
        check.remove();
        return index;
    }

    private static void removeShape(int index) throws IOException{
        String input;
        separator();
        if (!checkIndexValid(index)){
            System.out.print("No such shape is found\n");
            return;
        }
        System.out.print(database.get(index).toString() + "\n");
        System.out.print("Enter Y if you want to remove the shape\n");
        System.out.print("Enter anything else if you you changed your mind\n");
        input = input();
        if (input.equalsIgnoreCase("Y")){
            database.get(index).remove();
            database.remove(index);
        }
    }

    private static void chooseActionToShape(int index) throws IOException{
        int choice;
        separator();
        if (!checkIndexValid(index)){
            System.out.print("No such shape is found\n");
        }
        else {
            System.out.print("What would you to do with this shape?\n" +
                    "1. Get Area\n" +
                    "2. Get Parameter\n" +
                    "3. Get characteristic\n" +
                    "4. Manipulate characteristic\n");
            choice = Integer.parseInt(input());
            switch (choice) {
                case 1:
                    separator();
                    System.out.print("The Area is: " + database.get(index).findArea() + "\n");
                    break;
                case 2:
                    separator();
                    System.out.print("The Parameter is: " + database.get(index).findParameter() + "\n");
                    break;
                case 3:
                    separator();
                    System.out.print(database.get(index).toString() + "\n");
                    break;
                case 4:
                    manipulateHub(index);
                    break;
            }
        }
    }
    //Hub to choose which characteristic to manipulate
    private static void manipulateHub(int index) throws IOException{
        int input;
        int newValue;
        separator();
        System.out.print(database.get(index).toString() + "\n");
        System.out.print("What would you like to change?\n");
        System.out.print("1. Side 1\n");
        if (database.get(index).getClass() == Rectangle.class
                || database.get(index).getClass() == Parallelogram.class
                || database.get(index).getClass() == Kite.class
                || database.get(index).getClass() == Trapezoid.class)
            System.out.print("2. Side 2\n");
        if (database.get(index).getClass() == Rhombus.class)
            System.out.print("2. Height\n");
        if (database.get(index).getClass() == Parallelogram.class
                || database.get(index).getClass() == Trapezoid.class)
            System.out.print("3. Height\n");
        if (database.get(index).getClass() == Kite.class) {
            System.out.print("3. Diagonal 1\n");
            System.out.print("4. Diagonal 2\n");
        }
        if (database.get(index).getClass() == Trapezoid.class) {
            System.out.print("4. Top\n");
            System.out.print("5. Base\n");
        }
        input = Integer.parseInt(input());
        System.out.print("What's the new value?\n");
        newValue = Integer.parseInt(input());
        switch (input) {
            case 1:
                manipulateSide1(index, newValue);
                break;
            case 2:
                if (database.get(index).getClass() == Rhombus.class)
                    manipulateHeight(index, newValue);
                else
                    manipulateSide2(index, newValue);
                break;
            case 3:
                if (database.get(index).getClass() == Kite.class)
                    manipulateDiag1(index, newValue);
                else
                    manipulateHeight(index, newValue);
                break;
            case 4:
                if (database.get(index).getClass() == Kite.class)
                    manipulateDiag2(index, newValue);
                else
                    manipulateTop(index, newValue);
                break;
            case 5:
                manipulateBot(index, newValue);
                break;
        }
    }
    //Below are the methods used for manipulating each specific characteristic of the shape
    private static void manipulateSide1(int index, int input) {
        if (database.get(index).getClass() == Square.class)
            ((Square)database.get(index)).setSide1(input);
        if (database.get(index).getClass() == Rectangle.class)
            ((Rectangle)database.get(index)).setSide1(input);
        if (database.get(index).getClass() == Rhombus.class)
            ((Rhombus)database.get(index)).setSide1(input);
        if (database.get(index).getClass() == Parallelogram.class)
            ((Parallelogram)database.get(index)).setSide1(input);
        if (database.get(index).getClass() == Kite.class)
            ((Kite)database.get(index)).setSide1(input);
        if (database.get(index).getClass() == Trapezoid.class)
            ((Trapezoid)database.get(index)).setSide1(input);
    }
    private static void manipulateSide2(int index, int input) {
        if (database.get(index).getClass() == Rectangle.class)
            ((Rectangle)database.get(index)).setSide2(input);
        if (database.get(index).getClass() == Parallelogram.class)
            ((Parallelogram)database.get(index)).setSide2(input);
        if (database.get(index).getClass() == Kite.class)
            ((Kite)database.get(index)).setSide2(input);
        if (database.get(index).getClass() == Trapezoid.class)
            ((Trapezoid)database.get(index)).setSide2(input);
    }
    private static void manipulateHeight(int index, int input) {
        if (database.get(index).getClass() == Rhombus.class)
            ((Rhombus)database.get(index)).setHeight(input);
        if (database.get(index).getClass() == Parallelogram.class)
            ((Parallelogram)database.get(index)).setHeight(input);
        if (database.get(index).getClass() == Trapezoid.class)
            ((Trapezoid)database.get(index)).setHeight(input);
    }
    private static void manipulateDiag1(int index, int input) {
        ((Kite)database.get(index)).setDiag1(input);

    }
    private static void manipulateDiag2(int index, int input) {
        ((Kite)database.get(index)).setDiag2(input);

    }
    private static  void manipulateTop(int index, int input) {
        ((Trapezoid)database.get(index)).setTop(input);


    }
    private static void manipulateBot(int index, int input) {
        ((Trapezoid)database.get(index)).setBot(input);

    }

    private static void list() {
        separator();
        for (int i = 0; i < database.size(); i++)
            System.out.print((i + 1) + ". " + database.get(i).getClassName() + "\n");
        System.out.print("# of Quadrilateral: " + Quadrilateral.getQuadNum() + "\n");
        System.out.print("# of Square: " + Square.getNum() + "\n");
        System.out.print("# of Rectangle: " + Rectangle.getNum() + "\n");
        System.out.print("# of Rhombus: " + Rhombus.getNum() + "\n");
        System.out.print("# of Parallelogram: " + Parallelogram.getNum() + "\n");
        System.out.print("# of Kite: " + Kite.getNum() + "\n");
        System.out.print("# of Trapezoid: " + Trapezoid.getNum() + "\n");
    }

    // Check if the database is full / empty
    private static boolean checkFull() {
        return database.size() < 20;

    }
    private static boolean checkEmpty() {
        return database.size() == 0;

    }
    // Check if index returned is valid
    private static boolean checkIndexValid(int index) {
        return index >= 0 && index < 20;

    }

    // Below are outputs methods for menu and other info

    private static void mainMenu() {
        separator();
        System.out.print("Please choose one of the option below\n" +
                "1. Add a shape\n" +
                "2. Remove a shape\n" +
                "3. Find a shape\n" +
                "4. List all shapes\n" +
                "5. Exit program\n");
    }

    private static void shapeMenu() {
        separator();
        System.out.print("Please choose one of the shape\n" +
                "1. Square\n" +
                "2. Rectangle\n" +
                "3. Rhombus\n" +
                "4. Parallelogram\n" +
                "5. Kite\n" +
                "6. Trapezoid\n");
    }

    private static void indexKeyCharacteristicMenu() {
        separator();
        System.out.print("Would you like to search by index or key?\n");
        System.out.print("1. Index\n");
        System.out.print("2. Key\n");
        System.out.print("3. Characteristic (Return the first appeareance)\n");
    }

    private static void end() {
        separator();
        System.out.print("End of program\nThank you\n");
    }

    private static void separator() {
        System.out.print("-----------------------------------------------------------------\n");
    }

    // Below is the input method

    private static String input() throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        return br.readLine();
    }
}