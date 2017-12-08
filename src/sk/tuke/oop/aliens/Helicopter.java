package sk.tuke.oop.aliens;

import sk.tuke.oop.aliens.actor.AbstractActor;
import sk.tuke.oop.framework.Animation;

public class Helicopter extends AbstractActor {
    private Animation helicopter;
    private int heliX;
    private int heliY;
    private int playerX;
    private int playerY;
    private boolean isSearching;

    public Helicopter(){
        isSearching = false;

        helicopter = new Animation("resources/images/heli.png",64,64,10);
        helicopter.setPingPong(true);
        setAnimation(helicopter);
    }

    public void searchAndDestroy(){
        isSearching = true;
    }

    /*
    Finds player and chasing him
     */
    @Override
    public void act(){
        if(isSearching){
            heliY = this.getY();    // x coordinate of heli
            heliX = this.getX();    // y coordinate of heli
            playerX = getPlayer().getX();   // x coordinate of player
            playerY = getPlayer().getY();   // y coordinate of player

            if(heliX > playerX) heliX -= 1; // -----player----<<heli------
            if(heliX < playerX) heliX += 1; // -----heli>>>---player------
            if(heliY < playerY) heliY += 1; // heli is below player
            if(heliY > playerY) heliY -= 1; // heli is above player

            this.setPosition(heliX,heliY);  // sets new position of heli

            if(this.intersects(getPlayer())){   //finds out if heli is intersected with player and hits him
                int playerEnergy = getPlayer().getEnergy();
                if(playerEnergy > 0) getPlayer().setEnergy(playerEnergy-1);
            }
        }
    }
}
