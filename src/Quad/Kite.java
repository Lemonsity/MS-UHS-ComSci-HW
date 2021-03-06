package Quad;

import java.util.ArrayList;

public class Kite extends Quadrilateral{
    private double side1;
    private double side2;
    private double diag1;
    private double diag2;
    private String key;
    private static ArrayList<Boolean> numUsed = new ArrayList<>();
    private static int kiteNum;
    public Kite(){
        super();
        side1 = 0;
        side2 = 0;
        diag1 = 0;
        diag2 = 0;
        if (getClass() == Kite.class) {
            kiteNum += 1;
            boolean emptySpot = false;
            for (int i = 0; i < numUsed.size(); i++) {
                if (numUsed.get(i) == false) {
                    key = "Kite " + (i + 1);
                    numUsed.set(i, true);
                    emptySpot = true;
                    break;
                }
            }
            if (!emptySpot) {
                key = "Kite " + kiteNum;
                numUsed.add(true);
            }
        }
    }
    public Kite(double side1, double side2, double diag1, double diag2){
        this.side1 = side1;
        this.side2 = side2;
        this.diag1 = diag1;
        this.diag2 = diag2;
        if (getClass() == Kite.class) {
            kiteNum += 1;
            key = "Kite " + kiteNum;
        }
    }

    public void setSide1(double side1) { this.side1 = side1; }
    public void setSide2(double side2) { this.side2 = side2; }
    public void setDiag1(double diag1) { this.diag1 = diag1; }
    public void setDiag2(double diag2) { this.diag2 = diag2; }

    public double getSide1() {
        return side1;
    }
    public double getSide2() {
        return side2;
    }
    public double getDiag1() {
        return diag1;
    }
    public double getDiag2() {
        return diag2;
    }

    // Abstract appearance
    public double findArea(){
        return getDiag1() * getDiag2() / 2;
    }
    public double findParameter() {
        return (getSide1() + getSide2()) * 2;
    }
    public String toString(){ return "<Kite> Side 1:" + getSide1() + ", Side 2: " + getSide2() + ", Diagonal 1: " +  getDiag1() + ", Diagonal 2: " + getDiag2() + ", Key: " + getKey(); }

    // Abstract identification
    public static int getNum() { return kiteNum; }
    public String getKey() { return key; }
    public String getClassName() { return "Kite "; }

    // Manipulate identification
    public boolean equals(Object o){
        if (o.getClass() ==  Kite.class){
            Kite ob = (Kite) o;
            return this.getSide1() == ob.getSide1()
                    && this.getSide2() == ob.getSide2()
                    && this.getDiag1() == ob.getDiag1()
                    && this.getDiag2() == ob.getDiag2();
        }
        return false;
    }
    public void remove() {
        if (getClass() == Kite.class) {
            kiteNum -= 1;
            super.subtractAmount();
            String[] keyNum = getKey().split(" ");
            if (Integer.parseInt(keyNum[1]) == numUsed.size())
                numUsed.remove(numUsed.size() - 1);
            else
                numUsed.set(Integer.parseInt(keyNum[1]) - 1, false);
        }
    }
}
