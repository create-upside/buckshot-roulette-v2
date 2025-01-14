package game.buckshot.roulette.domain.entities.rules;

import game.buckshot.roulette.domain.entities.Shotgun;

public class ShotgunRule {
    private static final int MINIMUM_DISTINCT_SHELLS = 2;
    private static final int MAX_RETRY_ATTEMPTS = 100;

    static public void validate(Shotgun shotgun) {
        int attempts = 0;
        while (hasInsufficientDistinctShells(shotgun) && attempts < MAX_RETRY_ATTEMPTS) {
            regenerateShells(shotgun);
            attempts++;
        }

        if (hasInsufficientDistinctShells(shotgun)) {
            throw new IllegalStateException("Failed to generate valid shell configuration after " + MAX_RETRY_ATTEMPTS + " attempts");
        }
    }

    private static boolean hasInsufficientDistinctShells(Shotgun shotgun) {
        return shotgun.getShells() != null &&
                !shotgun.getShells().isEmpty() &&
                shotgun.getShells().stream()
                        .distinct()
                        .count() < MINIMUM_DISTINCT_SHELLS;
    }

    private static void regenerateShells(Shotgun shotgun) {
        int currentSize = shotgun.getShells().size();
        shotgun.setShells(shotgun.generateShotgunShells(currentSize));
    }
}