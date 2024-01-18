package yhproject.playground.springevent.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;
import yhproject.playground.springevent.constants.BombType;

@Slf4j
@Component
@RequiredArgsConstructor
public class BombEventListener {

    @EventListener
    public void handleBomb(BombEvent event) {
        if (BombType.EVENT_LISTENER.equals(event.bombType())) {
            throw new RuntimeException("Event Listener Bomb!!!!!!!!!!");
        }
    }

    @TransactionalEventListener
    public void handleTransactionalBomb(BombEvent event) {
        if (BombType.TRANSACTIONAL_EVENT_LISTENER.equals(event.bombType())) {
            throw new RuntimeException("Transactional Event Listener Bomb!!!!!!!!!!");
        }
    }

    @Async("customExecutor")
    @EventListener
    public void handleAsyncBomb(BombEvent event) {
        if (BombType.ASYNC_EVENT_LISTENER.equals(event.bombType())) {
            throw new RuntimeException("Async Event Listener Bomb!!!!!!!!!!");
        }
    }

    @Async("customExecutor")
    @TransactionalEventListener
    public void handleAsyncTransactionalBomb(BombEvent event) {
        if (BombType.ASYNC_TRANSACTIONAL_EVENT_LISTENER.equals(event.bombType())) {
            throw new RuntimeException("Async Transactional Event Listener Bomb!!!!!!!!!!");
        }
    }

}
