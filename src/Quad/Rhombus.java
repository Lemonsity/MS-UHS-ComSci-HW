package Quad;

public class Rhombus extends Square{
    private int height;
    private static int rhomNum;
    public Rhombus(){
        super();
        height = 0;
        if (getClass() == Rhombus.class)
            rhomNum += 1;
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
