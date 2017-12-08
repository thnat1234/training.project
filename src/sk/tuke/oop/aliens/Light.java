package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Light extends AbstractActor{
    protected Animation lightOffAnimation;
    protected Animation lightOnAnimation;
    protected boolean isPowered;
    protected boolean isOn;


    public Light(){
        lightOffAnimation = new Animation("images/light_off.png", 16, 16, 10);
        lightOnAnimation = new Animation("images/light_on.png",16,16,10);

        setAnimation(lightOffAnimation);

        isPowered = false;
        isOn = false;
    }


    /*
    Switches light on or off, by isElectricityOn state
     */
    public void toggle(){
        if(isOn != true){
            isOn = true;
        }else{
            isOn = false;
            setAnimation(lightOffAnimation);
        }

        if(isOn && isPowered){
            setAnimation(lightOnAnimation);
        }


    }


    /*
    Sets electricity on or off
     */
    public void setElectricityFlow(boolean setFlow){
        if(setFlow){
            isPowered = true;
            if(isOn) {
                setAnimation(lightOnAnimation);
            }
        }else {
            isPowered = false;
            setAnimation(lightOffAnimation);
        }
    }
}
