package Quad;

public class Rhombus extends Square{
    private int height;
    public Rhombus(){

    }
    public void setHeight(int height){
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
    @Override
    public int findArea(){
        return getSide1() * height;
    }

    @Override
    public int findParameter(){
        return getSide1() * 4;
    }

}
