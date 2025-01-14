package game.buckshot.roulette.domain.entities.items;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;
import game.buckshot.roulette.domain.entities.Shell;
import game.buckshot.roulette.domain.entities.Shotgun;
import game.buckshot.roulette.domain.interfaces.Item;

import java.util.Queue;

public class MagnifyingGlass implements Item {

    @Override
    public void use(Player user, Round round) {
        Shotgun shotgun = round.getShotgun();
        Queue<Shell> shells = shotgun.getShells();
        if(shells.isEmpty()) {
            throw new IllegalStateException("There are no shotgun shells to peek");
        }
        Shell nextShell = shells.peek();
        System.out.println("Next shell is "+ nextShell.getShellType());
    }

    @Override
    public String getName() {
        return "🔍";
    }

    @Override
    public String getDescription() {
        return "Peek next bullet off shotgun";
    }
}
