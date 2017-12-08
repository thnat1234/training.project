package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Controller extends AbstractActor {
    private Reactor reactor;

    public Controller(Reactor reactor){
            this.reactor = reactor;

        Animation reactorSwitch = new Animation("images/switch.png", 16, 16, 10);
        setAnimation(reactorSwitch);

    }


    /*
    Method to turnOn/turnOFF reactor
     */
  /*  public void toggle(){
        if(reactor == null) return;
        if(reactor.isRunning()){
            reactor.turnOff();
        }else{
            reactor.turnOn();
        }
    }*/
}
