
package Model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ShelfObject extends AbstractObject{

    public static final int SPRITE_HEIGHT = 4;
    private static final int MAX_MSTATE = 1;//??????????????????????????????????
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int width;

    public ShelfObject(int x, int y, int width, boolean horizontalOnly) {
        setX(x);
        setY(y);
        this.width = width;
        setVisible(true);
        setHorizontalOnly(true);
        
        spriteImages[0] = new BufferedImage(width, SPRITE_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = spriteImages[0].createGraphics();
        g2.setColor(Color.BLACK);
        g2.setBackground(Color.BLACK);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(20));
        g2.drawLine(0, 0, getWidth(), 0);
        g2.dispose();
    }

    @Override
    public void setY(int y) {
            if(!isHorizontalOnly()){           
                super.setY(y);
                setHorizontalOnly(true);
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return SPRITE_HEIGHT;
    }

  

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }
  
}
