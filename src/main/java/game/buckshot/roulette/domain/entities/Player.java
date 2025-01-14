package game.buckshot.roulette.domain.entities;

import game.buckshot.roulette.domain.values.Health;
import game.buckshot.roulette.domain.values.PlayerState;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Player {
    @Getter
    private final UUID id;

    @Getter
    @Setter
    private Health health;

    @Getter
    @Setter
    private PlayerState playerState;

    public Player() {
        this.id = UUID.randomUUID();
    }
}
