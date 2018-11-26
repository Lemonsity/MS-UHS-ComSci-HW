package Quad;

public class Parallelogram extends Rectangle{
    private int height;
    private static int paraNum;
    public Parallelogram(){
        super();
        height = 0;
        if (getClass() == Parallelogram.class)
            paraNum += 1;
    }
    public Parallelogram(int side1, int side2, int height) {
        super();
        setSide1(side1);
        setSide2(side2);
        this.height = height;
        if (getClass() == Parallelogram.class)
            paraNum += 1;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getParaNum() { return paraNum;}

    public void remove() {
        if (getClass() == Parallelogram.class)
            paraNum -= 1;
    }

    @Override
    public String toString() {
        return "<Parallelogram> Side 1: " + getSide1() + ", Side 2: " + getSide2() + ", Height: " + getHeight();
    }
    @Override
    public int findArea(){
        return height * getSide1();
    }
    @Override
    public int findParameter(){
        return (getSide1() + getSide2()) * 2;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Parallelogram object = (Parallelogram) o;
        if (this.getSide1() != object.getSide1()
                || this.getSide2() != object.getSide2()
                || this.getHeight() != object.getHeight())
            return false;
        return true;
    }
}
