package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class FireExtinguisher extends AbstractTool {
    protected int maxUsages;

    public FireExtinguisher(){
        super(1);
        maxUsages = 1;

        Animation fireExtinguisher = new Animation("images/extinguisher.png", 16, 16, 10);
        setAnimation(fireExtinguisher);
    }

}
