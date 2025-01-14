package game.buckshot.roulette.domain.entities.items;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;
import game.buckshot.roulette.domain.entities.Shell;
import game.buckshot.roulette.domain.entities.Shotgun;
import game.buckshot.roulette.domain.interfaces.Item;
import game.buckshot.roulette.domain.values.Damage;

import java.util.Queue;

public class HandSaw implements Item {

    @Override
    public void use(Player user, Round round) {
        Shotgun shotgun = round.getShotgun();
        Queue<Shell> shells = shotgun.getShells();
        if(shells.isEmpty()) {
            throw new IllegalStateException("There is no next shell to be enhanced");
        }
        Shell nextShell = shells.poll();
        Damage oldDamage = nextShell.getDamage();
        Damage newDamage = new Damage(oldDamage.value() * 2);
        nextShell.setDamage(newDamage);
        shells.offer(nextShell);
    }

    @Override
    public String getName() {
        return "Hand saw 🔪";
    }

    @Override
    public String getDescription() {
        return "Increase damage of next bullet by 2";
    }
}
