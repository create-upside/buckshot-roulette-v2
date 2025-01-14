package game.buckshot.roulette.domain.events;

import java.util.UUID;

public interface DomainEvent {
    UUID getEventId();
}
