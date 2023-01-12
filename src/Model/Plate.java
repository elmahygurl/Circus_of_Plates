
package Model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Plate extends FallingObject {


    public Plate(int posX, int posY, String path, Color color) {
        super(posX, posY, path,color);
    }
    private static final int MAX_MSTATE = 1;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];


    @Override
    public void setImage(ImageObject image) {
        this.clown = image;
    }

    @Override
    public void setPath(String path) {
        if (this.getColor() == Color.RED) {
            super.setPath(path);
        } else {
            super.setPath(path);
        }
    }

        @Override
    public int getWidth() {
            return 83;
        }

    @Override
    public int getHeight() {       
            return 13;
    }
}
