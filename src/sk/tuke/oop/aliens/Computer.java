package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Computer extends AbstractActor {

    public Computer(){

    }


    /*
    Addition of 2 int numbers
     */
    public int add(int a, int b){
        return (a+b);
    }

    /*
    Addition of 2 double numbers
     */
    public double add(double a, double b){
        return (a+b);
    }

    /*
    Subtraction of 2 numbers
     */
    public int sub(int a, int b){
        return (a-b);
    }

    /*
    Subtraction of 2 numbers
     */
    public double sub(double a, double b){
        return (a-b);
    }
}
