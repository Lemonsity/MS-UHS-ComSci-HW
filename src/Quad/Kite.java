package Quad;

public class Kite extends Quadrilateral{
    private int side1;
    private int side2;
    private int diag1;
    private int diag2;
    private static int kiteNum;
    public Kite(){
        super();
        side1 = 0;
        side2 = 0;
        diag1 = 0;
        diag2 = 0;
        if (getClass() == Kite.class)
            kiteNum += 1;
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
    @Override
    public int findArea(){
        return diag1 * diag2 / 2;
    }
    @Override
    public int findParameter() {
        return (side1 + side2) * 2;
    }

}
