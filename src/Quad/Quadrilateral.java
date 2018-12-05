package Quad;

public abstract class Quadrilateral {
    private static int quadNum;
    public Quadrilateral(){
        // because all shapes are quadrilateral, thus whenever a shape is created, 1 is added to quadrilateral counter
        quadNum += 1;
    }

    /**
     * Update the amount of quadrilateral in the database
     *
     * I mean we could of just use ArrayList.size()
     *
     * But I think this way show better understanding of OOP
     */
    public void subtractAmount() { quadNum -= 1;} // update amount of quadrilateral
    public static int getQuadNum() { return quadNum; } // return amount of quadrilateral

    abstract double findArea(); // find area
    abstract double findParameter(); // find parameter
    abstract String getKey(); // key of the shape
    abstract String getClassName(); // get the name of the shape
    abstract void remove(); // update the amount of shape when removed from database
}
