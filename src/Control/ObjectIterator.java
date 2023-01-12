package Control;

import eg.edu.alexu.csd.oop.game.GameObject;
import java.util.Iterator;
import java.util.List;

public class ObjectIterator implements Iterator<GameObject> {

    int i = 0;
    List<GameObject> list;

    public ObjectIterator(List<GameObject> L) {
        this.list = L;
    }

    @Override
    public boolean hasNext() {
        if (i < list.size()/2) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public GameObject next() {
        return list.get(i++); 
        
    }

}