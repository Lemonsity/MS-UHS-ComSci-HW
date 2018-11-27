package Quad;

public abstract class Quadrilateral {
    private static int quadNum;
    public Quadrilateral(){
        quadNum += 1;
    }

    public int getQuadNum() { return quadNum; }
    public void subtractAmount() { quadNum -= 1;}
    abstract void remove();
    abstract int getNum();
    abstract int findArea();
    abstract int findParameter();
}
