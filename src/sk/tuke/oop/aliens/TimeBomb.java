package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class TimeBomb extends AbstractActor{

    private Animation timeBombAnimation;
    private Animation timeBombAnimationActivated;
    private Animation explosion;
    private boolean isActivated;
    private int time;

    public TimeBomb(int explodeTime){
        isActivated = false;

        timeBombAnimation = new Animation("resources/images/bomb.png",16,16,100);
        timeBombAnimationActivated = new Animation("resources/images/bomb_activated.png", 16,16,100);
        explosion = new Animation("resources/images/small_explosion.png",16,16,100);

        timeBombAnimationActivated.setPingPong(true);
        setAnimation(timeBombAnimation);
        this.time = explodeTime;
    }

    public void activate(){
        isActivated = true;
        setAnimation(timeBombAnimationActivated);
    }

    public boolean isActivated(){
        return this.isActivated;
    }

    @Override
    public void act(){
        if(isActivated){
            time -= 1;
            if(time == 0){
                setAnimation(explosion);
            }
            if(time == -9){
                getWorld().removeActor(this);
            }
        }
    }
}
