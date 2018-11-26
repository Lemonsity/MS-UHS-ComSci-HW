package Quad;

public class Square extends Quadrilateral{
    private int side1;
    private static int squareNum;
    public Square(){
        super();
        side1 = 0;
        if (getClass() == Square.class)
            squareNum += 1;
    }

    public void setSide1(int side1) { this.side1 = side1; }

    public int getSide1() {
        return side1;
    }

    public int getSquareNum() { return squareNum; }
    @Override
    public String toString() {
        return "<Square> Side 1: " + getSide1();
    }
    @Override
    public int findArea() {
        return side1 * side1;
    }
    @Override
    public int findParameter() {
        return side1 * 4;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Square object = (Square) o;
        if (this.getSide1() != object.getSide1())
            return false;
        return true;
    }
}
