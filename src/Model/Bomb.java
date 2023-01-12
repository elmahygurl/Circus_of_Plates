package Model;

import java.awt.Color;


public class Bomb extends FallingObject {

     public Bomb(int posX, int posY, String path, Color color) {
        super(posX, posY, path, color);
    }
       public Bomb(boolean horizontalOnly) {
        super(horizontalOnly);
       }
     
    @Override
    public int getWidth() {
            return 57;
    }
    @Override
    public int getHeight() {
       return 52;
    }
}

