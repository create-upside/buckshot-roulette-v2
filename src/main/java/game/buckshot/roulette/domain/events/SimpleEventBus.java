package game.buckshot.roulette.domain.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class SimpleEventBus implements DomainEventPublisher, DomainEventSubscriber {
    private final Map<Class<? extends DomainEvent>, List<Consumer<? extends DomainEvent>>> subscribers = new HashMap<>();

    @Override
    public <T extends DomainEvent> void subscribe(Class<T> eventType, Consumer<T> handler) {
        subscribers.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }

    @Override
    public void unsubscribe(Class<? extends DomainEvent> eventType, Consumer<? extends DomainEvent> handler) {
        if (subscribers.containsKey(eventType)) {
            subscribers.get(eventType).remove(handler);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void publish(DomainEvent event) {
        if (subscribers.containsKey(event.getClass())) {
            subscribers.get(event.getClass()).forEach(handler ->
                    ((Consumer<DomainEvent>) handler).accept(event));
        }
    }
}

