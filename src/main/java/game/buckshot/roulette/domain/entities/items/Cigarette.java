package game.buckshot.roulette.domain.entities.items;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;
import game.buckshot.roulette.domain.interfaces.Item;
import game.buckshot.roulette.domain.values.Health;

public class Cigarette implements Item {

    @Override
    public void use(Player user, Round round) {
        Health oldHealth = user.getHealth();
        Health newHealth = new Health(oldHealth.value() + 1);
        user.setHealth(newHealth);
    }

    @Override
    public String getName() {
        return "Cigarette 🚬";
    }

    @Override
    public String getDescription() {
        return "+1 HP";
    }
}
