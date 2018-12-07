package Quad;

import java.util.ArrayList;

public class Rhombus extends Square{
    private double height;
    private String key;
    private static ArrayList<Boolean> numUsed = new ArrayList<>();
    private static int rhomNum;
    public Rhombus(){
        super();
        height = 0;
        if (getClass() == Rhombus.class) {
            rhomNum += 1;
            boolean emptySpot = false;
            for (int i = 0; i < numUsed.size(); i++) {
                if (numUsed.get(i) == false) {
                    key = "Rhombus " + (i + 1);
                    numUsed.set(i, true);
                    emptySpot = true;
                    break;
                }
            }
            if (!emptySpot) {
                key = "Rhombus " + rhomNum;
                numUsed.add(true);
            }
        }
    }
    public Rhombus (double side1, double height) {
        setSide1(side1);
        this.height = height;
        if (getClass() == Rhombus.class) {
            rhomNum += 1;
            key = "Rh" + rhomNum;
        }
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight() { return height; }


    public double findArea(){
        return getSide1() * getHeight();
    }
    public double findParameter(){
        return getSide1() * 4;
    }
    public String toString() {
        return "<Rhombus> Side 1: " + getSide1() + ", Height: " + getHeight() + ", Key: " + getKey();
    }

    public static int getNum() { return rhomNum; }
    public String getKey() {
        return key;
    }
    public String getClassName() { return "Rhombus "; }

    public boolean equals(Object o){
        if (o.getClass() ==  Rhombus.class){
            Rhombus ob = (Rhombus) o;
            return this.getSide1() == ob.getSide1()
                    && this.getHeight() == ob.getHeight();
        }
        return false;
    }
    public void remove() {
        if (getClass() == Rhombus.class) {
            rhomNum -= 1;
            super.subtractAmount();
            String[] keyNum = getKey().split(" ");
            if (Integer.parseInt(keyNum[1]) == numUsed.size())
                numUsed.remove(numUsed.size() - 1);
            else
                numUsed.set(Integer.parseInt(keyNum[1]) - 1, false);
        }
    }
}
