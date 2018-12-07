package Quad;

import java.util.ArrayList;

public class Parallelogram extends Rectangle{
    private double height;
    private String key;
    private static ArrayList<Boolean> numUsed = new ArrayList<>();
    private static int paraNum;
    public Parallelogram(){
        super();
        height = 0;
        if (getClass() == Parallelogram.class) {
            paraNum += 1;
            boolean emptySpot = false;
            for (int i = 0; i < numUsed.size(); i++) {
                if (numUsed.get(i) == false) {
                    key = "Parallelogram " + (i + 1);
                    numUsed.set(i, true);
                    emptySpot = true;
                    break;
                }
            }
            if (!emptySpot) {
                key = "Parallelogram " + paraNum;
                numUsed.add(true);
            }
        }
    }
    public Parallelogram(double side1, double side2, double height) {
        super();
        setSide1(side1);
        setSide2(side2);
        this.height = height;
        if (getClass() == Parallelogram.class) {
            paraNum += 1;
            key = "Parallelogram " + paraNum;
        }
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public double findArea(){
        return getHeight() * getSide1();
    }
    public double findParameter(){
        return (getSide1() + getSide2()) * 2;
    }
    public String toString() { return "<Parallelogram> Side 1: " + getSide1() + ", Side 2: " + getSide2() + ", Height: " + getHeight() + ", Key: " + getKey(); }

    public static int getNum() { return paraNum;}
    public String getKey() { return key; }
    public String getClassName() { return "Parallelogram "; }

    public boolean equals(Object o){
        if (o.getClass() ==  Parallelogram.class){
            Parallelogram ob = (Parallelogram) o;
            return this.getSide1() == ob.getSide1()
                    && this.getSide2() == ob.getSide2()
                    && this.getHeight() == ob.getHeight();
        }
        return false;
    }
    public void remove() {
        if (getClass() == Parallelogram.class) {
            paraNum -= 1;
            super.subtractAmount();
            String[] keyNum = getKey().split(" ");
            if (Integer.parseInt(keyNum[1]) == numUsed.size())
                numUsed.remove(numUsed.size() - 1);
            else
                numUsed.set(Integer.parseInt(keyNum[1]) - 1, false);
        }
    }
}
