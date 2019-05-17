package observer.sample;

import observer.ISubject;
import observer.Observer;

public class Hero extends Observer implements ISubject {

    private int noise;
    private String status = "Hidden";

    public void move(){
        noise++;
        System.out.println("Player Status: " + this.status);
        notify(Events.PLAYER_MOVED.getValue(), this);

    }

    public int getNoise() {
        return noise;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public void onNotify(String message, Object object) {
        if(message == Events.DRAGON_WAKE.getValue()){
            this.status = "Visible!";
            System.out.println("Player Status: " + this.status);
            System.out.println("You awake the dragon!! Run!!");
        }
    }
}
