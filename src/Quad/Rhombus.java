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

    public int getHeight() { return height; }

    @Override
    public int findArea(){
        return getSide1() * height;
    }

    @Override
    public int findParameter(){
        return getSide1() * 4;
    }
    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        else if (o == null)
            return false;
        else if (this.getClass() != o.getClass())
            return false;
        Rhombus object = (Rhombus) o;
        if (this.getSide1() != object.getSide1()
                || this.getHeight() != object.getHeight())
            return false;
        return true;
    }

}
