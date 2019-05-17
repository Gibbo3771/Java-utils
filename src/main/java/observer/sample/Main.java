package observer.sample;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero();
        Dragon dragon = new Dragon();
        NoiseManagementSystem noiseManagementSystem = new NoiseManagementSystem();

        // The noise system is listening to both the hero and the dragon for events
        noiseManagementSystem.register(hero);
        noiseManagementSystem.register(dragon);
        // The hero is listening to the noise system for changes
        hero.register(noiseManagementSystem);
        while(true){
            hero.move();
            if(hero.getStatus() == "Visible!") break;
            try{
                Thread.sleep(200);

            }catch(Exception e){
                System.err.println(e);
            }
        }
    }
}
