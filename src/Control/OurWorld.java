package Control;

import Model.Bomb;
import Model.FallingObject;
import Model.ImageObject;
import eg.edu.alexu.csd.oop.game.GameObject;
import eg.edu.alexu.csd.oop.game.World;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import Model.Plate;
import Model.Skittles;

public class OurWorld implements World {
//testing

    private int chances = 3;
    private static final int MAX_TIME = 1 * 60 * 1000;	// 1 minute
    private int score = 0;
    private long startTime = System.currentTimeMillis();
    private int width;
    private int height;
    private final List<GameObject> constant = new LinkedList<GameObject>();
    private final List<GameObject> moving = new LinkedList<GameObject>();
    private final List<GameObject> control = new LinkedList<GameObject>();
    private List<GameObject> leftHand = new LinkedList<GameObject>();
    private List<GameObject> rightHand = new LinkedList<GameObject>();
    private Strategy s;
    private Iterator<GameObject> mIterator = moving.iterator();
    private Iterator<GameObject> nIterator = moving.iterator();
    OnLeftHandState L = new OnLeftHandState();
    OnRightHandState R = new OnRightHandState();
    Skittles skit = null;
    private static boolean music;
    public OurWorld(Strategy x, int screenWidth, int screenHeight) {
        s = x;
        width = screenWidth;
        height = screenHeight;
        constant.add(ImageObject.getBackgroundInstance(0, 0, "/b7e.jpg")); //background image
        Generator g = new Generator(moving, constant, control);
        g.GenerateLeft();
        g.GenerateRight();
        System.out.println("generation works if size is  " + moving.size());
        System.out.println("testing a plate has y of  " + moving.get(1).getY());
       if (!music){
            AudioPlayer audio = AudioPlayer.getInstance("C:\\Users\\Lenovo\\Desktop\\FinalProg\\Circus2\\resources\\Circus-Theme-Song.wav");
            audio.play();
            music = true;
       }
    
    }

    @Override
    public boolean refresh() {
        boolean timeout = System.currentTimeMillis() - startTime > MAX_TIME; // time end and game over
        GameObject clown = control.get(0);   //getting the clown

        mIterator = new ObjectIterator(moving);        //left bar
        while (mIterator.hasNext()) {  //iterator
            GameObject m = (GameObject) mIterator.next();
            if (m.getX() + 175 < width / 2) {
                m.setX((int) (m.getX() + s.getSpeed()));
            } else {
                m.setX((int) (m.getX() + (Math.random() * 1000 % 2 + s.getSpeed() - 1)));
                m.setY((int) (m.getY() + Math.random() * 1000 % 12));
            }
            operation(clown, m);
        }
        Collections.reverse(moving);
        nIterator = new ObjectIterator(moving);
        while (nIterator.hasNext()) {
            GameObject m = (GameObject) nIterator.next();
            if (m.getX() - 100 > width / 2) {
                m.setX((int) (m.getX() - s.getSpeed()));
            } else {
                m.setX((int) (m.getX() - (Math.random() * 1000 % 2 + s.getSpeed() - 1)));
                m.setY((int) (m.getY() + Math.random() * 1000 % 12));
            }
            operation(clown, m);
        }
        if (skit != null) {
            skit.setY(skit.getY() + 12);
        }
        updateLeftHand();
        updateRightHand();
        adjustPlatesToClown();
        Collections.reverse(moving);
        return !timeout;
    }

    private void operation(GameObject clown, GameObject m) {
        if (leftHand.isEmpty()) {
            if (touchLeftHand(m)) {
                moving.remove(m);
                FallingObject p = (FallingObject) m;
                p.setImage((ImageObject) clown);
                p.setHorizontalOnly(true);
                p.setState(L);
                control.add(m);
                leftHand.add(m);
                p.move();
                return;

            }
        } else {
            if (intersect(m, leftHand.get(leftHand.size() - 1))) {
                moving.remove(m);
                FallingObject p = (FallingObject) m;
                p.setImage((ImageObject) clown);
                p.setHorizontalOnly(true);
                p.setState(L);
                control.add(m);
                leftHand.add(m);
                p.move();
                if (leftHand.size() > 10) {
                    startTime = MAX_TIME;
                }
                return;

            }
        }

        //...........................................................
        
        if (rightHand.isEmpty()) {
            if (touchRightHand(m)) {
                moving.remove(m);
                FallingObject p = (FallingObject) m;
                p.setImage((ImageObject) clown);
                p.setHorizontalOnly(true);
                p.setState(R);
                control.add(m);
                rightHand.add(m);
                p.move();

            }
        } else {
            if (intersect(m, rightHand.get(rightHand.size() - 1))) {
                moving.remove(m);
                FallingObject p = (FallingObject) m;
                p.setImage((ImageObject) clown);
                p.setHorizontalOnly(true);
                p.setState(R);
                control.add(m);
                rightHand.add(m);
                p.move();
                if (rightHand.size() > 10) {
                    startTime = MAX_TIME;
                }
            }

        }
    }

    private boolean touchLeftHand(GameObject o) {
        boolean FlagY = false;
        boolean FlagX = false;
        FallingObject f = (FallingObject) o;
        ImageObject clown = (ImageObject) control.get(0);

        if (f instanceof Bomb) {
            FlagY = ((o.getY() <= 400) && (o.getY() >= 395));
            FlagX = (Math.abs(clown.getX()) < f.getX()) && (f.getX() < Math.abs(clown.getX() + clown.getWidth()));
        } else {
            FlagY = ((o.getY() <= 448) && (o.getY() >= 440));
            FlagX = (Math.abs(clown.getX() - o.getX()) <= 50);
        }
        return (FlagY && FlagX);

    }

    private void updateLeftHand() {
        if (leftHand.size() > 0) {
            FallingObject f = (FallingObject) leftHand.get(leftHand.size() - 1);
            if (f instanceof Bomb) {
                FallingObject bomb = (FallingObject) leftHand.get(leftHand.size() - 1);
                
                leftHand.remove(leftHand.size() - 1);
                control.remove(bomb);
                chances = Math.max(0, chances - 1);
               AudioPlayer audio = AudioPlayer.getInstance("C:\\Users\\Lenovo\\Desktop\\FinalProg\\Circus2\\resources\\Bomb-Sound.wav");
               audio.play();
                if (chances == 0) {
                    startTime = MAX_TIME;
                }

            } else if (f instanceof Skittles) {
                leftHand.remove(leftHand.size() - 1);
                control.remove(f);
                chances++;
            }
        }

        if (leftHand.size() >= 3) {
            FallingObject p1 = (FallingObject) leftHand.get(leftHand.size() - 1);
            FallingObject p2 = (FallingObject) leftHand.get(leftHand.size() - 2);
            FallingObject p3 = (FallingObject) leftHand.get(leftHand.size() - 3);
            if (p1.getPath().equals(p2.getPath()) && p2.getPath().equals(p3.getPath())) {
                leftHand.remove(leftHand.size() - 1);
                leftHand.remove(leftHand.size() - 1);
                leftHand.remove(leftHand.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                score++;
            }
        }
    }

    private boolean touchRightHand(GameObject o) {
        boolean FlagY = false;
        boolean FlagX = false;
        FallingObject f = (FallingObject) o;
        ImageObject clown = (ImageObject) control.get(0);

        if (f instanceof Bomb) {
            FlagY = ((o.getY() <= 400) && (o.getY() >= 395));
            FlagX = (Math.abs(clown.getX()) < f.getX()) && (f.getX() < Math.abs(clown.getX() + clown.getWidth()));
        } else if (f instanceof Plate) {
            FlagX = (Math.abs(clown.getX() + clown.getWidth() - o.getX() - f.getWidth()) + 25 <= f.getWidth());
            FlagY = ((o.getY() <= 448) && (o.getY() >= 440));
        } else {
            FlagY = ((o.getY() <= 448) && (o.getY() >= 440));
            FlagX = (Math.abs(clown.getX() + clown.getWidth() - o.getX() - f.getWidth()) <= f.getWidth());
        }
        return (FlagY && FlagX);

    }

    private void updateRightHand() {
        if (rightHand.size() > 0) {
            FallingObject f = (FallingObject) rightHand.get(rightHand.size() - 1);
            if (f instanceof Bomb) {
                FallingObject bomb = (FallingObject) rightHand.get(rightHand.size() - 1);

                rightHand.remove(rightHand.size() - 1);
                control.remove(bomb);
                chances = Math.max(0, chances - 1);
                AudioPlayer audio = AudioPlayer.getInstance("C:\\Users\\Lenovo\\Desktop\\FinalProg\\Circus2\\resources\\Bomb-Sound.wav");
                audio.play();
                if (chances == 0) {
                    startTime = MAX_TIME;
                }
            } else if (f instanceof Skittles) {
                rightHand.remove(rightHand.size() - 1);
                control.remove(f);
                chances++;
            }
        }

        if (rightHand.size() >= 3) {
            FallingObject p1 = (FallingObject) rightHand.get(rightHand.size() - 1);
            FallingObject p2 = (FallingObject) rightHand.get(rightHand.size() - 2);
            FallingObject p3 = (FallingObject) rightHand.get(rightHand.size() - 3);
            if (p1.getPath().equals(p2.getPath()) && p2.getPath().equals(p3.getPath())) {
                rightHand.remove(rightHand.size() - 1);
                rightHand.remove(rightHand.size() - 1);
                rightHand.remove(rightHand.size() - 1);
                control.remove(p1);
                control.remove(p2);
                control.remove(p3);
                score++;
            }
        }
    }

    @Override
    public String getStatus() {
        String difficulty;
        difficulty = switch (s.getSpeed()) {
            case 1 ->
                "Easy";
            case 2 ->
                "Medium";
            default ->
                "Hard";
        };
        return "Score=" + score + "   |   Time=" + Math.max(0, (MAX_TIME - (System.currentTimeMillis() - startTime)) / 1000) + "   |   Level:" + difficulty + "   |   Lives left = " + chances;
    }

    private boolean intersect(GameObject o1, GameObject o2) {
        return (Math.abs((o1.getX() + o1.getWidth() / 2) - (o2.getX() + o2.getWidth() / 2)) <= o1.getWidth()) && (Math.abs((o1.getY() + o1.getHeight() / 2) - (o2.getY() + o2.getHeight() / 2)) <= o1.getHeight());
    }

    @Override
    public int getSpeed() {
        return s.getSpeed();
    }

    @Override
    public int getControlSpeed() {
        return 20;
    }

    @Override
    public List<GameObject> getConstantObjects() {
        return constant;
    }

    @Override
    public List<GameObject> getMovableObjects() {
        return moving;
    }

    @Override
    public List<GameObject> getControlableObjects() {
        return control;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void adjustPlatesToClown() {
        for (int i = 0; i < leftHand.size(); i++) {
            FallingObject f = (FallingObject) leftHand.get(i);
            f.move();
        }
        for (int i = 0; i < rightHand.size(); i++) {
            FallingObject f = (FallingObject) rightHand.get(i);
            f.move();
        }
    }

}
