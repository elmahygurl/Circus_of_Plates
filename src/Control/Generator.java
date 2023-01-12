
package Control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.awt.Color;
import java.util.List;

public class Generator {

    int i;
    List<GameObject> moving;
    List<GameObject> constant;
    List<GameObject> control;
    ObjectFactory ob = new ObjectFactory();

    public Generator(List<GameObject> moving, List<GameObject> constant, List<GameObject> control) {
        this.moving = moving;
        this.constant = constant;
        this.control = control;
    }

    public void GenerateLeft() {

        control.add(ob.CreateShape("Clown",(int) (1000 * 0.4), (int) (700 * 0.625), "/Clown.png",Color.LIGHT_GRAY));
        constant.add(ob.CreateShape("Shelf",0, 50,"shelf",Color.BLUE)); //0,50,325
        constant.add(ob.CreateShape("Shelf",675, 50,"shelf",Color.BLUE)); //675,1000
        
        for (i = 0; i < 55; i++) {
            if (i==4 || i==15 ||i==28 || i==40) {
                moving.add(ob.CreateShape("Skittles",0 - 75 * (3 * i), 15, "/object666.png", Color.ORANGE));

            } else {
                int rand = ((int) (Math.random() * 1000) % 5);
                switch (rand) {
                    case 0 ->
                        moving.add(ob.CreateShape("Plate",0 - 75 * (3 * i), 40, "/object1b.png", Color.RED));
                    case 1 ->
                        moving.add(ob.CreateShape("Plate",0 - 75 * (3 * i), 40, "/object2b.png", Color.BLUE));
                    case 2 ->
                        moving.add(ob.CreateShape("Plate",0 - 75 * (3 * i), 40, "/object3b.png", Color.YELLOW));
                    case 3 ->
                        moving.add(ob.CreateShape("Plate",0 - 75 * (3 * i), 40, "/object4b.png", Color.GREEN));
                    case 4 ->
                        moving.add(ob.CreateShape("Bomb",0 - 75 * (3 * i), -20, "/object5.png", Color.BLACK));

                    default -> {
                    }
                }
            }
        }
    }

    public void GenerateRight() {
        for (i = 0; i < 55; i++) {
            if (i==11 || i==21 || i==35 || i==46) {
                moving.add(ob.CreateShape("Skittles",800 + 75 * (3 * i), 15, "/object666.png", Color.ORANGE));

            } else {
                int rand = ((int) (Math.random() * 1000) % 5);
                switch (rand) {
                    case 0 ->
                        moving.add(ob.CreateShape("Plate",800 + 75 * (3 * i), 40, "/object1b.png", Color.RED));
                    case 1 ->
                        moving.add(ob.CreateShape("Plate",800 + 75 * (3 * i), 40, "/object2b.png", Color.BLUE));
                    case 2 ->
                        moving.add(ob.CreateShape("Plate",800 + 75 * (3 * i), 40, "/object3b.png", Color.YELLOW));
                    case 3 ->
                        moving.add(ob.CreateShape("Plate",800 + 75 * (3 * i), 40, "/object4b.png", Color.GREEN));
                    case 4 ->
                        moving.add(ob.CreateShape("Bomb",800 + 75 * (3 * i), -20, "/object5.png", Color.BLACK));
                    default -> {
                    }
                }
            }
        }
    }
}
