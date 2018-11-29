package Quad;

public class Kite extends Quadrilateral{
    private int side1;
    private int side2;
    private int diag1;
    private int diag2;
    private String key;
    private static int kiteNum;
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
    public Kite(int side1, int side2, int diag1, int diag2){
        this.side1 = side1;
        this.side2 = side2;
        this.diag1 = diag1;
        this.diag2 = diag2;
        if (getClass() == Kite.class) {
            kiteNum += 1;
            key = "Kite " + kiteNum;
        }
    }

    public void setSide1(int side1) { this.side1 = side1; }
    public void setSide2(int side2) { this.side2 = side2; }
    public void setDiag1(int diag1) { this.diag1 = diag1; }
    public void setDiag2(int diag2) { this.diag2 = diag2; }

    public int getSide1() {
        return side1;
    }
    public int getSide2() {
        return side2;
    }
    public int getDiag1() {
        return diag1;
    }
    public int getDiag2() {
        return diag2;
    }
    public String getKey() { return key; }

    public int getNum() { return kiteNum; }

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
    public int findArea(){
        return getDiag1() * getDiag2() / 2;
    }
    @Override
    public int findParameter() {
        return (getSide1() + getSide2()) * 2;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Kite object = (Kite) o;
        if (this.getSide1() != object.getSide1()
                || this.getSide2() != object.getSide2()
                || this.getDiag1() != object.getDiag1()
                || this.getDiag2() != object.getDiag2())
            return false;
        return true;
    }
}
