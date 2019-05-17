package observer.sample;

public enum Events {
    PLAYER_MOVED("playermoved"),
    DRAGON_WAKE("dragonwake");

    private final String value;

    Events(String name) {
        this.value = name;
    }

    public String getValue() {
        return value;
    }
}
