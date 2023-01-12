
package Control;

import Model.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;

public class OnLeftHandState implements State{

    @Override
    public void move(GameObject gameObject,ImageObject clown) {
      gameObject.setX(clown.getX() - 5);
    }
    
}
