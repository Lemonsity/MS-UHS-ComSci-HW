package Quad;

public class Rhombus extends Square{
    private double height;
    private static int rhomNum;
    private String key;
    public Rhombus(){
        super();
        height = 0;
        if (getClass() == Rhombus.class) {
            rhomNum += 1;
            key = "Rhombus " + rhomNum;
        }
    }
    public Rhombus (double side1, double height) {
        setSide1(side1);
        this.height = height;
        if (getClass() == Rhombus.class) {
            rhomNum += 1;
            key = "Rh" + rhomNum;
        }
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getHeight() { return height; }

    public static int getNum() { return rhomNum; }

    public String getClassName() { return "Rhombus "; }


    @Override
    public String getKey() {
        return key;
    }

    public void remove() {
        if (getClass() == Rhombus.class) {
            rhomNum -= 1;
            super.subtractAmount();
        }
    }

    @Override
    public String toString() {
        return "<Rhombus> Side 1: " + getSide1() + ", Height: " + getHeight();
    }
    @Override
    public double findArea(){
        return getSide1() * getHeight();
    }
    @Override
    public double findParameter(){
        return getSide1() * 4;
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass() ==  Rhombus.class){
            Rhombus ob = (Rhombus) o;
            return this.getSide1() == ob.getSide1()
                    && this.getHeight() == ob.getHeight();
        }
        return false;
    }
}
