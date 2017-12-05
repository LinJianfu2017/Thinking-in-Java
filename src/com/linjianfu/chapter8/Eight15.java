package com.linjianfu.chapter8;

class Glyph{
    void draw(){
        System.out.println("Glyph.draw()");
    }
    Glyph(){
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}
class RoundGlyph extends Glyph{
    private int radius=1;
    RoundGlyph(int r){
        radius=r;
        System.out.println("RoundGlyph.RoundGlyph(),radius= " + radius);
    }
    @Override
    void draw(){
        System.out.println("RoundGlyph.draw(),radius= " + radius);
    }
}
class RectangularGlyph extends Glyph{
    private int sidelength=2;
    RectangularGlyph(int b){
        sidelength=b;
        System.out.println("RectangularGlyph.RectangularGlyph(),sidelength= " + sidelength);
    }
    @Override
    void draw(){
        System.out.println("RecangularGlyph.draw(),sidelength= " + sidelength);
    }
}
public class Eight15 {
    public static void main(String[] args) {
        new RoundGlyph(6);
        new  RectangularGlyph(5);
    }
}
