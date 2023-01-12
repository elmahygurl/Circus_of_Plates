
package Model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageObject extends AbstractObject {

    private static ImageObject clownInstance = null;
    private static ImageObject BackgroundImage = null;
    private static final int MAX_MSTATE = 1;
    private boolean flag = true;
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];

    private ImageObject(int posX, int posY, String path) {
        setX(posX);
        super.setY(posY);
        flag = true;
        this.setVisible(true);
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ImageObject getInstance(int posX, int posY, String path) {
        if (clownInstance == null) {
            clownInstance = new ImageObject(posX, posY, path);
        }
        return clownInstance;
    }

    public static ImageObject getBackgroundInstance(int posX, int posY, String path) {
        if (BackgroundImage == null) {
            BackgroundImage = new ImageObject(posX, posY, path);
        }
        return BackgroundImage;
    }
    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        //return spriteImages[0].getWidth()-275;
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public void setY(int mY) {

    }

}
