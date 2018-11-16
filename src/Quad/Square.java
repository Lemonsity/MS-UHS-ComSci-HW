package Quad;

public class Square extends Quadrilateral{
    private int side1;
    public Square(){

    }

    public void setSide1(int side1) {
        this.side1 = side1;
    }

    public int getSide1() {
        return side1;
    }

    @Override
    public int findArea() {
        return side1 * side1;
    }

    @Override
    public int findParameter() {
        return side1 * 4;
    }
}
