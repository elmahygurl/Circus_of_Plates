
package Control;

import Model.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;

public interface State {
    public void move (GameObject gameObject,ImageObject clown);
}
