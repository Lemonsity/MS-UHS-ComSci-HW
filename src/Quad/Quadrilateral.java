package Quad;

public abstract class Quadrilateral {
    private static int quadNum;
    public Quadrilateral(){
        quadNum = 0;
    }
    abstract int findArea();
    abstract int findParameter();
    public int getQuadNum() { return quadNum; }
}
