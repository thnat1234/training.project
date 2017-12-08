package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Reactor extends AbstractActor {
    private int temperature;
    private int damage;
    private boolean isRunning;
    private Animation normalAnimation;
    private Animation hotAnimation;
    private Animation brokenAnimation;
    private Animation reactorOffAnimation;
    private Animation reactorExtinguished;
    private String manufacturer = "NorthKorea";
    private Light light;

    public Reactor(){
        isRunning = false;

        normalAnimation = new Animation("images/reactor_on.png", 80, 80, 100);
        hotAnimation = new Animation("images/reactor_hot.png", 80, 80, 50);
        brokenAnimation = new Animation("images/reactor_broken.png", 80, 80, 100);
        reactorOffAnimation = new Animation("images/reactor.png", 80, 80, 100);
        reactorExtinguished = new Animation("images/reactor_extinguished.png", 80, 80, 100);

        normalAnimation.setPingPong(true);
        hotAnimation.setPingPong(true);
        brokenAnimation.setPingPong(true);
        reactorOffAnimation.setPingPong(true);
        reactorExtinguished.setPingPong(true);

        setAnimation(reactorOffAnimation);
    }

    // Returns temperature of reactor
    public int getTemperature() {
        return this.temperature;
    }

    // Returns damage of reactor
    public int getDamage() {
        return this.damage;
    }

    /*
    Increases temperature in reactor and set up animations
     */
    public void increaseTemperature(int increment) {

        if (increment >= 0 && isRunning) {
            if (damage >= 33 && damage <= 66) {
                increment *= 1.5;
            }

            if (damage >= 66) {
                increment *= 2;
            }
            temperature += increment;

            if (temperature > 2000) {
                damage = (int) ((100 / 4000.0) * (temperature - 2000));
            }

            if (temperature > 6000) {
                damage = 100;
            }

            updateAnimation();
        }

    }

    /*
    Decreases temperature in reactor. Function is not able to decrease damage of reactor.
     */
    public void decreaseTemperature(int decrement){

        if(damage < 100 && temperature > 0 && decrement > 0 && isRunning) {

            if (damage >= 50) {
                decrement *= 0.5;
            }

            temperature -= decrement;

            updateAnimation();
        }
    }

    /*
    Based on temperature sets animation
     */
    private void updateAnimation(){
        if(temperature < 4000){
            setAnimation(normalAnimation);
        }else if(temperature > 4000 && temperature < 6000){
            int durationAnimation = 200 - (int) (temperature * 0.03);
            hotAnimation.setDuration(durationAnimation);
            setAnimation(hotAnimation);
        }else if(temperature > 6000){
            setAnimation(brokenAnimation);
        }

        if(!isRunning && damage < 100){
            setAnimation(reactorOffAnimation);
        }

    }

    /*
       Returns true if temperature is over 3000 and damage over 50
     */
    public boolean isServiceNeeded(){
        if(temperature > 3000 && damage > 50) return TRUE;
        else return FALSE;
    }

    /*
    Method for repairing reactor
     */
    public void repairWith(Hammer hammer){
        if(hammer instanceof Hammer && damage > 0 && damage < 100){

            temperature = ((damage - 50) * 40) + 2000;

            if(damage > 50){
                damage -= 50;
                updateAnimation();
            }else{
                damage = 0;
                updateAnimation();
            }

            hammer.use();
        }
    }

    /*
    Turn reactor ON
     */
    public void turnOn(){

        isRunning = true;
        if(this.light != null) {
            this.light.setElectricityFlow(true);
        }
        updateAnimation();
    }

    /*
    Turn reactor OFF
     */
    public void turnOff(){
        isRunning = false;

        if(this.light != null) {
            this.light.setElectricityFlow(false);

        }

        updateAnimation();
    }

    /*
    Returns true if reactor is running, false otherwise
     */
    public boolean isRunning(){
        return isRunning;
    }

    /*
    Adds light to reactor
     */
    public void addLight(Light light){
        if(light != null) {
            this.light = light;
        }

        if(isRunning && damage < 100){
            light.setElectricityFlow(true);
        }else {
            light.setElectricityFlow(false);
        }
    }

    /*
    Removes light from reactor
     */
    public void removeLight(){
        light = null;
    }

    /*
    Extinguish destroyed reactor.
     */
    public void extinguishWith(FireExtinguisher fireext){
        if(temperature >= 6000 && damage >= 100){
            temperature = 4000;
            setAnimation(reactorExtinguished);
            fireext.use();
        }
    }

    /*
    Override method from AbstractActor
    Sets temperature to 1degree higher on every call
     */
    @Override
    public void act(){
        if(isRunning && damage < 100)
        temperature += 1;
        updateAnimation();
    }
}
