package Quad;

import java.util.ArrayList;

public class Square extends Quadrilateral{
    private double side1;
    private String key;
    private static ArrayList<Boolean> numUsed = new ArrayList<>();
    private static int squareNum;
    public Square(){
        super();
        side1 = 0;
        if (getClass() == Square.class) {
            squareNum += 1;
            boolean emptySpot = false;
            for (int i = 0; i < numUsed.size(); i++) {
                if (numUsed.get(i) == false) {
                    key = "Square " + (i + 1);
                    numUsed.set(i, true);
                    emptySpot = true;
                    break;
                }
            }
            if (!emptySpot) {
                key = "Square " + squareNum;
                numUsed.add(true);
            }
        }
    }
    public Square (double side1) {
        super();
        this.side1 = side1;
        if (getClass() == Square.class) {
            squareNum += 1;
            key = "Square " + squareNum;
        }
    }

    public void setSide1(double side1) { this.side1 = side1; }

    public double getSide1() {
        return side1;
    }

    public double findArea() {
        return getSide1() * getSide1();
    }
    public double findParameter() {
        return getSide1() * 4;
    }
    public String toString() { return "<Square> Side 1: " + getSide1() + ", Key: " + getKey(); }

    public static int getNum() { return squareNum; }
    public String getKey() { return key; }
    public String getClassName() { return "Square "; }

    public boolean equals(Object o){
        if (o.getClass() == Square.class){
            Square ob = (Square) o;
            return this.getSide1() == ob.getSide1();
        }
        return false;
    }
    public void remove() {
        if (getClass() == Square.class) {
            squareNum -= 1;
            super.subtractAmount();
            String[] keyNum = getKey().split(" ");
            if (Integer.parseInt(keyNum[1]) == numUsed.size())
                numUsed.remove(numUsed.size() - 1);
            else
                numUsed.set(Integer.parseInt(keyNum[1]) - 1, false);
        }
    }
}
