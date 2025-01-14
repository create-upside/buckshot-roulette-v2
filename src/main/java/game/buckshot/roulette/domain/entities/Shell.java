package game.buckshot.roulette.domain.entities;

import game.buckshot.roulette.domain.values.Damage;
import game.buckshot.roulette.domain.values.ShellType;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Shell {
    private final UUID id;

    @Getter
    @Setter
    private Damage damage;

    @Getter
    private final ShellType shellType;

    public Shell(ShellType shellType) {
        this.shellType = shellType;
        this.id = UUID.randomUUID();
    }
}
