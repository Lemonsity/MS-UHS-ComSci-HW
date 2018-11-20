package Quad;

public class Main {
    public static void main(String[] args){
        Parallelogram p = new Parallelogram();
        p.setHeight(4);
        p.setSide1(4);
        p.setSide2(2);
        System.out.println(p.findArea());
        System.out.print(p.findParameter());
    }
}
