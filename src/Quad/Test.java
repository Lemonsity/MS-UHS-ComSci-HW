package Quad;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//This is a class that help me test feature of the Java language and other class specific functions
public class Test {

    public static List<Quadrilateral> database = new ArrayList<>(); // database

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int choice; // Choice made in main menu
        int choiceShape;
        mainMenu();
        choice = Integer.parseInt(input());
        while (choice != 5) { // if user doesn't choose to end program (5)
            switch (choice) {
                case 1:
                    shapeMenu();
                    choiceShape = Integer.parseInt(input());
                    shapeInitial(choiceShape);
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }
            mainMenu();
            choice = Integer.parseInt(input());
        }
        end(); // End of program
    }

    public static void separator() {
        System.out.print("-----------------------------------------------------------------\n");
    }

    public static void mainMenu() {
        separator();
        System.out.print("Please choose one of the option below\n" +
                "1. Add a shape\n" +
                "2. Remove a shape\n" +
                "3. Find a shape\n" +
                "4. List all shapes\n" +
                "5. Exit program\n");
    }

    public static void shapeMenu() {
        separator();
        System.out.print("Please choose one of the shape\n" +
                "1. Square\n" +
                "2. Rectangle\n" +
                "3. Rhombus\n" +
                "4. Parallelogram\n" +
                "5. Kite\n" +
                "6. Trapezoid\n");
    }

    public static void shapeInitial(int shape) throws IOException{
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
        int choiceDC = Integer.parseInt(input());
        if (choiceDC == 1)
            defaultShape(shape);
        else
            customShape(shape);
    }

    /**
     * defaultShape()
     *
     * method that adds default shape
     */
    public static void defaultShape(int shape) {
        switch (shape) {
            case 1:
                database.add(new Square());
                break;
            case 2:
                database.add(new Rectangle());
                break;
            case 3:
                database.add(new Rhombus());
                break;
            case 4:
                database.add(new Parallelogram());
                break;
            case 5:
                database.add(new Kite());
                break;
            case 6:
                database.add(new Trapezoid());
                break;
        }
    }
    /**
     * customShape()
     *
     * method that adds custom shape
     */
    public static void customShape(int shape) throws IOException{
        String reenter;
        double side1, side2 = 0, height = 0, diag1 = 0, diag2 = 0, top = 0, bot = 0; // Shape characteristic
        do {
            separator();
            System.out.print("Please enter the length of side 1 (The length of the left slope if it's trapezoid):\n");
            side1 = Integer.parseInt(input());
            if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                System.out.print("Please enter the length of side 2 (The length of the right slope if it's trapezoid):\n");
                side2 = Integer.parseInt(input());
            }
            if (shape == 3 || shape == 4 || shape == 6) {
                System.out.print("Please enter the height:\n");
                height = Integer.parseInt(input());
            }
            if (shape == 5) {
                System.out.print("Please enter length of diagonal 1:\n");
                diag1 = Integer.parseInt(input());
                System.out.print("Please enter length of diagonal 2:\n");
                diag2 = Integer.parseInt(input());
            }
            if (shape == 6) {
                System.out.print("Please enter length of top:\n");
                top = Integer.parseInt(input());
                System.out.print("Please enter length of bottom:\n");
                bot = Integer.parseInt(input());
            }
            //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            System.out.printf("Side 1: %d, ", side1);
            if (shape == 2 || shape == 4 || shape == 5 || shape == 6) {
                System.out.printf("Side 2: %d, ", side2);
            }
            if (shape == 3 || shape == 4 || shape == 6) {
                System.out.printf("Side height: %d, ", height);
            }
            if (shape == 5) {
                System.out.printf("Diagonal 1: %d, ", diag1);
                System.out.printf("Diagonal 2: %d, ", diag2);

            }
            if (shape == 6) {
                System.out.printf("Top: %d, ", top);
                System.out.printf("Base: %d, ", bot);
            }
            System.out.print("\nEnter Y if you are satisfied with the characteristic\n");
            System.out.print("Enter anything else if you want to reenter\n");
            reenter = input();
        } while (!reenter.equalsIgnoreCase("Y"));
        switch (shape) {
            case 1:
                database.add(new Square(side1));
                break;
            case 2:
                database.add(new Rectangle(side1, side2));
                break;
            case 3:
                database.add(new Rhombus(side1, height));
                break;
            case 4:
                database.add(new Parallelogram(side1, side2, height));
                break;
            case 5:
                database.add(new Kite(side1, side2, diag1, diag2));
                break;
            case 6:
                database.add(new Trapezoid(top, bot, height, side1, side2));
                break;
        }
    }

    public static void end() {
        separator();
        System.out.print("End of program");
    }

    public static String input() throws IOException{
        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        return br.readLine();
    }
}