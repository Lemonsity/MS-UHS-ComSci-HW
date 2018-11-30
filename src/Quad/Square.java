package Quad;

public class Square extends Quadrilateral{
    private double side1;
    private String key;
    private static int squareNum;
    public Square(){
        super();
        side1 = 0;
        if (getClass() == Square.class) {
            squareNum += 1;
            key = "Square " + squareNum;
        }
    }
    public Square (double side1) {
        super();
        this.side1 = side1;
        if (getClass() == Square.class) {
            squareNum += 1;
            key = "Square " + squareNum;
        }
    }

    public void setSide1(double side1) { this.side1 = side1; }

    public double getSide1() {
        return side1;
    }

    public static int getNum() { return squareNum; }

    public String getClassName() { return "Square "; }

    @Override
    public String getKey() { return key; }

    public void remove() {
        if (getClass() == Square.class) {
            squareNum -= 1;
            super.subtractAmount();
        }
    }
    @Override
    public String toString() { return "<Square> Side 1: " + getSide1(); }
    @Override
    public double findArea() {
        return getSide1() * getSide1();
    }
    @Override
    public double findParameter() {
        return getSide1() * 4;
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass() == Square.class){
            Square ob = (Square) o;
            return this.getSide1() == ob.getSide1();
        }
        return false;
    }
}
