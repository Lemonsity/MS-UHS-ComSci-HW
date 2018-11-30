package Quad;

public abstract class Quadrilateral {
    private static double quadNum;
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
    public double getQuadNum() { return quadNum; }

    abstract void remove(); // When a shape is removed from data base
    abstract double getNum();
    abstract double findArea();
    abstract double findParameter();
    abstract String getKey();
}
