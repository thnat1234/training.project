package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;


public class Hammer extends AbstractTool {

    private int hammerCounter;

    public Hammer(){
        super(1);
        hammerCounter = 1;

        Animation hammerAnimation = new Animation("images/hammer.png", 16, 16, 10);
        setAnimation(hammerAnimation);
    }

}
