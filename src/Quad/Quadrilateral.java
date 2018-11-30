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
    public static int getQuadNum() { return quadNum; }

    abstract double findArea();
    abstract double findParameter();
    abstract String getKey();
    abstract String getClassName();
    abstract void remove(); // When a shape is removed from data base
}
