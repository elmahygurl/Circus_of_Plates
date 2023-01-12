package Model;

import java.awt.Color;


public class Skittles extends FallingObject{
    
    public Skittles(int posX, int posY, String path, Color color) {
        super(posX, posY, path, color);
    }
    public Skittles(boolean horizontalOnly) {
        super(horizontalOnly);
       }

    @Override
    public int getWidth() {
            return 57;
    }
    @Override
    public int getHeight() {
       return 20;
    }
}
