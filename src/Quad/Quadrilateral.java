package Quad;

public abstract class Quadrilateral {
    private static int quadNum;
    public Quadrilateral(){
        quadNum += 1;
    }

    /**
     * Update the amount of quadrilateral in the database
     *
     * I mean we could of just use ArrayList.size()
     *
     * But I think this way show better understanding of OOP
     */
    public void subtractAmount() { quadNum -= 1;}

    public int getQuadNum() { return quadNum; }

    abstract void remove(); // When a shape is removed from data base
    abstract int getNum();
    abstract int findArea();
    abstract int findParameter();
}
