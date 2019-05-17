package observer.sample;

import observer.ISubject;
import observer.Observer;

public class NoiseManagementSystem extends Observer implements ISubject {

    private int totalNoise = 0;


    /**
     * Every time the player moves, we increase the noise value by 1 and if it exceeds 5, we notify
     * the dragon that the noise is too loud!
     *
     * @param message
     * @param object
     */
    @Override
    public void onNotify(String message, Object object) {
        if (message.equals(Events.PLAYER_MOVED.getValue())) {
            totalNoise += ((Hero) object).getNoise();
            System.out.println("Noise Management System: Footstep noises");
        }
        if (totalNoise > 5)
            notify(Events.DRAGON_WAKE.getValue(), null);
    }
}
