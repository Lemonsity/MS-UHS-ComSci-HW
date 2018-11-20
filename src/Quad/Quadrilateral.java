package Quad;

public abstract class Quadrilateral {
    private static int counter;
    public Quadrilateral(){
        counter = 0;
    }
    abstract int findArea();
    abstract int findParameter();
}
