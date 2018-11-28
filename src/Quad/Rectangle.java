package Quad;

public class Rectangle extends Square{
    private int side2;
    private String key;
    private static int rectNum;
    public Rectangle(){
        super();
        side2 = 0;
        if (this.getClass() == Rectangle.class) {
            rectNum += 1;
            key = "Rectangle " + rectNum;
        }
    }
    public Rectangle (int side1, int side2) {
        super();
        setSide1(side1);
        this.side2 = side2;
        if (this.getClass() == Rectangle.class) {
            rectNum += 1;
            key = "Rectangle " + rectNum;
        }
    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide2() {
        return side2;
    }

    @Override
    public int getNum() { return rectNum; }

    @Override
    public String getKey() {
        return key;
    }

    public void remove() {
        if (getClass() == Rectangle.class) {
            rectNum -= 1;
            super.subtractAmount();
        }
    }
    @Override
    public String toString() {
        return "<Rectangle> Side 1: " + getSide1() + ", Side 2: " + getSide2();
    }
    @Override
    public int findArea(){
        return side2 * getSide1();
    }
    @Override
    public int findParameter(){
        return (side2 + getSide1()) * 2;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Rectangle object = (Rectangle) o;
        if (this.getSide1() != object.getSide1()
                || this.getSide2() != object.getSide2())
            return false;
        return true;
    }
}
