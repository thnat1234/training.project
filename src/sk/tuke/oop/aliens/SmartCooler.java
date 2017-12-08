package sk.tuke.oop.aliens;

public class SmartCooler extends Cooler {
    private Reactor reactor;

    public SmartCooler(Reactor reactor){
        super(reactor);

        if(reactor != null){
            this.reactor = reactor;
        }
    }

    /*
    Smart cooler which keeps temperature in range of 1000 to 2000 degrees
     */
    @Override
    public void act(){
        if(reactor.getTemperature() < 1000){
            turnOff();
        }

        if(reactor.getTemperature() > 2000){
            turnOn();

            if(isOn() && reactor.getTemperature() > 0){
                reactor.decreaseTemperature(1);
            }
        }


    }
}
