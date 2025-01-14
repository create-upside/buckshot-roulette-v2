package game.buckshot.roulette.domain.entities;

import game.buckshot.roulette.domain.entities.rules.ShotgunRule;
import lombok.Getter;

import java.util.ArrayList;
import java.util.UUID;

public class Round {
    private final UUID id;

    private final ArrayList<Player> players;

    @Getter
    private final Shotgun shotgun;

    private void initializeRound () {
        ShotgunRule.validate(shotgun);
    }

    public Round(ArrayList<Player> players, Shotgun shotgun) {
        this.players = players;
        this.shotgun = shotgun;
        this.id = UUID.randomUUID();
        initializeRound();
    }
}
