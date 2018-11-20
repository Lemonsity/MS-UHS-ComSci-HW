package Quad;

public class Parallelogram extends Rectangle{
    private int height;
    public Parallelogram(){
        height = 0;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public int findArea(){
        return height * getSide1();
    }
    @Override
    public int findParameter(){
        return (getSide1() + getSide2()) * 2;
    }
}
