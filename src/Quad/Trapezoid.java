package Quad;

public class Trapezoid extends Quadrilateral {
    private double top;
    private double bot;
    private double height;
    private double side1;
    private double side2;
    private static int trapNum;
    private String key;
    public Trapezoid() {
        super();
        top = 0;
        bot = 0;
        height = 0;
        side1 = 0;
        side2 = 0;
        if (getClass() == Trapezoid.class) {
            trapNum += 1;
         }
    }
    public Trapezoid ( double top, double bot, double height, double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
        this.top = top;
        this.bot = bot;
        if (getClass() == Trapezoid.class) {
            trapNum += 1;
            key = "Trapezoid " + (trapNum);
        }
    }

    public void setTop(double top) { this.top = top; }
    public void setBot(double bot) { this.bot = bot; }
    public void setHeight(double height) { this.height = height; }
    public void setSide1(double side1) { this.side1 = side1; }
    public void setSide2(double side2) { this.side2 = side2; }

    public double getTop() { return top; }
    public double getBot() { return bot; }
    public double getHeight() { return height; }
    public double getSide1() { return side1; }
    public double getSide2() { return side2; }
    public String getKey() { return key; }
    public String getClassName() { return "Trapezoid "; }
    public static int getNum() { return trapNum;}

    public void remove() {
        if (getClass() == Trapezoid.class) {
            trapNum -= 1;
            super.subtractAmount();
        }

    }
    @Override
    public String toString() {
        return "<Trapezoid> Slope 1: " + getSide1() + ", Slope 2: " + getSide2() + ", Height: " + getHeight() + ", Top: " + getTop() + ", Bottom: " + getBot();
    }
    @Override
    public double findArea() { return (getTop() + getBot()) * getHeight()/ 2; }
    @Override
    public double findParameter(){
        return getTop() + getBot() + getSide1() + getSide2();
    }
    @Override
    public boolean equals(Object o){
        if (o.getClass() == Trapezoid.class){
            Square ob = (Square) o;
            return this.getSide1() == ob.getSide1();
        }
        return false;
    }
}
