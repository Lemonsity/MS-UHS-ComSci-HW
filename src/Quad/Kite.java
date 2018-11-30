package Quad;

public class Kite extends Quadrilateral{
    private double side1;
    private double side2;
    private double diag1;
    private double diag2;
    private String key;
    private static double kiteNum;
    public Kite(){
        super();
        side1 = 0;
        side2 = 0;
        diag1 = 0;
        diag2 = 0;
        if (getClass() == Kite.class) {
            kiteNum += 1;
            key = "Kite " + kiteNum;
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
    public String getKey() { return key; }

    public double getNum() { return kiteNum; }

    public void remove() {
        if (getClass() == Kite.class) {
            kiteNum -= 1;
            super.subtractAmount();
        }
    }

    @Override
    public String toString(){
        return "<Kite> Side 1:" + getSide1() + ", Side 2: " + getSide2() + ", Diagonal 1: " +  getDiag1() + ", Diagonal 2: " + getDiag2();
    }
    @Override
    public double findArea(){
        return getDiag1() * getDiag2() / 2;
    }
    @Override
    public double findParameter() {
        return (getSide1() + getSide2()) * 2;
    }
    @Override
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
}
