package game.buckshot.roulette.domain.entities;

import game.buckshot.roulette.domain.values.ShellType;
import lombok.Getter;
import lombok.Setter;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class Shotgun {
    private final UUID id;
    @Getter
    @Setter
    private Queue<Shell> shells;

    public Queue<Shell> generateShotgunShells (int limit) {
        Queue<Shell> newShells = new LinkedList<>();
        SecureRandom secureRandom = new SecureRandom();

        ShellType[] shellValues = ShellType.values();

        for (int i = 0; i < limit; i++) {
            int randIndex = secureRandom.nextInt(shellValues.length);
            newShells.add(new Shell(shellValues[randIndex]));
        }

        return newShells;
    }

    public Shotgun(Queue<Shell> shells) {
        this.id = UUID.randomUUID();
        this.shells = shells;
    }
}
