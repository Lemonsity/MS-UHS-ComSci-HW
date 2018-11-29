package Quad;

public class Square extends Quadrilateral{
    private int side1;
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
    public Square (int side1) {
        super();
        this.side1 = side1;
        if (getClass() == Square.class) {
            squareNum += 1;
            key = "Square " + squareNum;
        }
    }

    public void setSide1(int side1) { this.side1 = side1; }

    public int getSide1() {
        return side1;
    }

    public int getNum() { return squareNum; }

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
    public int findArea() {
        return getSide1() * getSide1();
    }
    @Override
    public int findParameter() {
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
