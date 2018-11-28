package Quad;

public class Trapezoid extends Quadrilateral {
    private int top;
    private int bot;
    private int height;
    private int side1;
    private int side2;
    private static int trapNum;
    public Trapezoid() {
        super();
        top = 0;
        bot = 0;
        height = 0;
        side1 = 0;
        side2 = 0;
        if (getClass() == Trapezoid.class)
            trapNum += 1;
    }
    public Trapezoid ( int top, int bot, int height, int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
        this.height = height;
        this.top = top;
        this.bot = bot;
        if (getClass() == Trapezoid.class)
            trapNum += 1;
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

    public int getNum() { return trapNum;}

    public void remove() {
        if (getClass() == Trapezoid.class) {
            trapNum -= 1;
            super.subtractAmount();
        }

    }
    @Override
    public String toString() {
        return "<Trapezoid> Slope 1: " + side1 + ", Slope 2: " + side2 + ", Height: " + height + ", Top: " + top + ", Bottom: " + bot;
    }
    @Override
    public int findArea() { return (top + bot) * height / 2; }
    @Override
    public int findParameter(){
        return top + bot + side1 + side2;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Trapezoid object = (Trapezoid) o;
        if (this.getSide1() != object.getSide1()
                || this.getSide2() != object.getSide2()
                || this.getTop() != object.getTop()
                || this.getBot() != object.getBot()
                || this.getHeight() != object.getHeight())
            return false;
        return true;
    }
}
