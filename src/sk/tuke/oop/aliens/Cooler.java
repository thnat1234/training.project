package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Cooler extends AbstractActor {

    private boolean isOn;
    private Reactor reactor;
    private Animation coolerAnimation;

    public Cooler(Reactor reactor){
        isOn = false;
        if (reactor != null){
            this.reactor = reactor;
        }

        coolerAnimation = new Animation("resources/images/fan.png",32,32,200);
        setAnimation(coolerAnimation);
        coolerAnimation.stop();

    }

    /*
    Turns cooler on
     */
    public void turnOn(){

        isOn = true;
        coolerAnimation.start();
    }

    /*
    Turns cooler off
     */
    public void turnOff(){
        isOn = false;
        coolerAnimation.stop();
    }

    /*
    Returns true if on, false otherwise
     */
    public boolean isOn(){
        return this.isOn;
    }

    /*
    If called, temperature will be lowered by 1 degree every time
     */
    public void act(){
        if(isOn && reactor.getTemperature() > 0 && reactor.getDamage() < 100){
            reactor.decreaseTemperature(1);
        }
    }
}
