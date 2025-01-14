package game.buckshot.roulette.domain.values;

public record Health(int value) {
    public Health {
        if(value < 0) {
            throw new RuntimeException("Health has reached a negative value");
        }
    }
}
