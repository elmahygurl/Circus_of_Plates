
package Control;
import Model.Bomb;
import Model.Bomb;
import Model.Bomb;
import Model.ImageObject;
import Model.ImageObject;
import Model.ImageObject;
import Model.Plate;
import Model.Plate;
import Model.Plate;
import Model.ShelfObject;
import Model.ShelfObject;
import Model.ShelfObject;
import Model.Skittles;
import Model.Skittles;
import Model.Skittles;
import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;

public class ObjectFactory {
    public ObjectFactory() {   
    }
    public GameObject CreateShape(String type,int x, int y, String path, Color color){
        if (type==null){
            return null;
        }
        else if (type.equals("Plate")){
            return new Plate(x,y,path,color);
        }else if (type.equals("Bomb")){
            return new Bomb(x,y,path,color);
        } else if (type.equals("Skittles")){
            return new Skittles(x,y,path,color);
        }else if (type.equals("Clown")){
            return ImageObject.getInstance(x, y, path);
        } else if (type.equals("Shelf")){
            return new ShelfObject(x, y,325, true);
        }
        return null;
    }

}
