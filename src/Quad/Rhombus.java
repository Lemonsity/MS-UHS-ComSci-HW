package Quad;

public class Rhombus extends Square{
    private int height;
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
    public Rhombus (int side1, int height) {
        setSide1(side1);
        this.height = height;
        if (getClass() == Rhombus.class) {
            rhomNum += 1;
            key = "Rh" + rhomNum;
        }
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight() { return height; }

    public int getNum() { return rhomNum; }

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
    public int findArea(){
        return getSide1() * getHeight();
    }
    @Override
    public int findParameter(){
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
