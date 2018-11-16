package Quad;

public class Trapezoid extends Quadrilateral {
    private int top;
    private int bot;
    private int height;
    private int side1;
    private int side2;

    public Trapezoid() {

    }

    public void setTop(int top) { this.top = top; }
    public void setBot(int bot) { this.bot = bot; }
    public void setHeight(int height) { this.height = height; }
    public void setSide1(int side1) { this.side1 = side1; }
    public void setSide2(int side2) { this.side2 = side2; }

    public int getTop() { return top; }
    public int getBot() { return bot; }
    public int getHeight() { return height; }
    public int getSide1() { return side1; }
    public int getSide2() { return side2; }

    @Override
    public int findArea() {
        return (top + bot) * height / 2;
    }
    @Override
    public int findParameter(){
        return top + bot + side1 + side2;
    }
}
