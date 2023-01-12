
package Control;

import Model.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;

public class OnRightHandState implements State {
    @Override
    public void move(GameObject gameObject, ImageObject clown) {
         gameObject.setX(clown.getX() + clown.getWidth() - 85);
    }
}
