package game.buckshot.roulette.domain.interfaces;

import game.buckshot.roulette.domain.entities.Player;
import game.buckshot.roulette.domain.entities.Round;

public interface Item {
    /**
     * Applies the item's effect on the given player.
     *
     * @param user The player using the item.
     * @param round The round context (e.g., current round, shotgun state, etc.).
     */
    void use(Player user, Round round);

    /**
     * Returns the name of the item.
     *
     * @return The name of the item.
     */
    String getName();

    /**
     * Provides a description of the item's effect.
     *
     * @return A string description of the item's effect.
     */
    String getDescription();
}
