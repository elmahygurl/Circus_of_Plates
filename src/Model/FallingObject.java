
package Model;
import Control.OnLeftHandState;
import Control.State;
import Control.OnRightHandState;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FallingObject extends AbstractObject {

    private static final int MAX_MSTATE = 1;
    private Color color;
    ImageObject clown;
    private String path;
    State state = null;
    private OnRightHandState R = new OnRightHandState();
    private OnLeftHandState L = new OnLeftHandState();
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //  an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

        
    public void move(){
        if(state!= null){
         getState().move(this,clown);
        }
    }

    public ImageObject getImage() {
        return clown;
    }

    public void setImage(ImageObject image) {
        this.clown = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FallingObject(int posX, int posY, String path,Color color) {
        super.setX(posX);
        super.setY(posY);
       
        this.setVisible(true);
        this.path = path;
        this.color = color;
        //  create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {

        }
    }

    public FallingObject(boolean horizontalOnly) {
        this.setHorizontalOnly(horizontalOnly);
    }


}
