package sk.tuke.oop.aliens;


import sk.tuke.oop.framework.Animation;

public class Mjolnir extends Hammer {

    private int maxUsage;
    private Animation thorHammer;


    public Mjolnir(){
        maxUsage = 4;

        thorHammer = new Animation("images/hammer.png", 16, 16, 10);
        setAnimation(thorHammer);
    }
}

