package game.buckshot.roulette.domain.entities.items;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;
import game.buckshot.roulette.domain.entities.Shell;
import game.buckshot.roulette.domain.entities.Shotgun;
import game.buckshot.roulette.domain.interfaces.Item;

import java.util.Queue;

public class Beer implements Item {
    @Override
    public void use(Player user, Round round) {

        Shotgun shotgun = round.getShotgun();
        Queue<Shell> shells = shotgun.getShells();
        if(shells.isEmpty()) {
            throw new IllegalStateException("There are no shotgun shells to rack");
        }
        Shell nextShell = shells.poll();
        System.out.println("Next shell was "+ nextShell.getShellType());
    }

    @Override
    public String getName() {
        return "Beer 🍺";
    }

    @Override
    public String getDescription() {
        return "Rack the next shell off the shotgun";
    }
}
