package Quad;

public class Rectangle extends Square{
    private int side2;
    public Rectangle(){

    }

    public void setSide2(int side2) {
        this.side2 = side2;
    }

    public int getSide2() {
        return side2;
    }
    @Override
    public int findArea(){
        return side2 * getSide1();
    }
    @Override
    public int findParameter(){
        return (side2 + getSide1()) * 2;
    }
}
