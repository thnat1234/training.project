package sk.tuke.oop.aliens;

public class DefectiveLight extends Light {

    public DefectiveLight(){

    }

    /*
    Defines behavior of bad light
     */
    @Override
    public void act(){
        if(((int)(Math.random() * 20)) == 5){
            toggle();
        }
    }
}
