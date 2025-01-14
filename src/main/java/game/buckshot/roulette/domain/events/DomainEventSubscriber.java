package game.buckshot.roulette.domain.events;
import java.util.function.Consumer;

public interface DomainEventSubscriber {
    <T extends DomainEvent> void subscribe(Class<T> eventType, Consumer<T> handler);
    void unsubscribe(Class<? extends DomainEvent> eventType, Consumer<? extends DomainEvent> handler);
}
