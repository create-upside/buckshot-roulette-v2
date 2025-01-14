package game.buckshot.roulette.domain.entities.items;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;
import game.buckshot.roulette.domain.interfaces.Item;

public class HandCuffs implements Item {
    @Override
    public void use(Player user, Round round) {

    }

    @Override
    public String getName() {
        return "Handcuffs";
    }

    @Override
    public String getDescription() {
        return "Change target's state to restrained for their next turn";
    }
}
