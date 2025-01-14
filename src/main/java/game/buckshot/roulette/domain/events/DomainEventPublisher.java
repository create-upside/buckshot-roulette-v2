package game.buckshot.roulette.domain.events;


public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
