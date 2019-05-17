package observer.sample;

import observer.ISubject;
import observer.Observer;

public class Dragon implements ISubject {

    private String status = "Sleeping...";

    public Dragon() {
        System.out.println("Dragon: ZZZzzzz");
    }

    @Override
    public void onNotify(String message, Object object) {
        if(message == Events.DRAGON_WAKE.getValue()){
            this.status = "Awake!";
            System.out.println(".....Roooooaaaarrr!!");
        }
    }
}
