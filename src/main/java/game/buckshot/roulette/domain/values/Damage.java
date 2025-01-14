package game.buckshot.roulette.domain.values;

public record Damage(int value) {
    public Damage {
        if (value < 1) {
            throw new IllegalArgumentException("Damage cannot be negative!");
        }
    }
}