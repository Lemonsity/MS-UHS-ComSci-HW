package Quad;

import java.util.ArrayList;

public class Rectangle extends Square{
    private double side2;
    private String key;
    private static ArrayList<Boolean> numUsed = new ArrayList<>();
    private static int rectNum;
    public Rectangle(){
        super();
        side2 = 0;
        if (this.getClass() == Rectangle.class) {
            rectNum += 1;
            boolean emptySpot = false;
            for (int i = 0; i < numUsed.size(); i++) {
                if (numUsed.get(i) == false) {
                    key = "Rectangle " + (i + 1);
                    numUsed.set(i, true);
                    emptySpot = true;
                    break;
                }
            }
            if (!emptySpot) {
                key = "Rectangle " + rectNum;
                numUsed.add(true);
            }
        }
    }
    public Rectangle (double side1, double side2) {
        super();
        setSide1(side1);
        this.side2 = side2;
        if (this.getClass() == Rectangle.class) {
            rectNum += 1;
            key = "Rectangle " + rectNum;
        }
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide2() {
        return side2;
    }

    public double findArea(){
        return side2 * getSide1();
    }
    public double findParameter(){
        return (side2 + getSide1()) * 2;
    }
    public String toString() {
        return "<Rectangle> Side 1: " + getSide1() + ", Side 2: " + getSide2() + ", Key: " + getKey();
    }

    public static int getNum() { return rectNum; }
    public String getKey() {
        return key;
    }
    public String getClassName() { return "Rectangle "; }

    public boolean equals(Object o){
        if (o.getClass() ==  Rectangle.class){
            Rectangle ob = (Rectangle) o;
            return this.getSide1() == ob.getSide1()
                    && this.getSide2() == ob.getSide2();
        }
        return false;
    }
    public void remove() {
        if (getClass() == Rectangle.class) {
            rectNum -= 1;
            super.subtractAmount();
            String[] keyNum = getKey().split(" ");
            if (Integer.parseInt(keyNum[1]) == numUsed.size())
                numUsed.remove(numUsed.size() - 1);
            else
                numUsed.set(Integer.parseInt(keyNum[1]) - 1, false);
        }
    }
}
