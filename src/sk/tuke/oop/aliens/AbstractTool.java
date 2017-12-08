package sk.tuke.oop.aliens;


import sk.tuke.oop.aliens.actor.AbstractActor;

public class AbstractTool extends AbstractActor {
    protected int possibleUses;

    public AbstractTool(int possibleUses){
        this.possibleUses = possibleUses;
    }

    public void use(){
        possibleUses -= 1;
        if(possibleUses <= 0){
            getWorld().removeActor(this);
        }
    }

}
