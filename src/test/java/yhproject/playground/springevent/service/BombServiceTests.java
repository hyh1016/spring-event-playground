package yhproject.playground.springevent.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import yhproject.playground.springevent.constants.BombType;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class BombServiceTests {

    @Autowired
    BombService bombService;

    @Test
    void eventListener_throw_propagate() {
        assertDoesNotThrow(() -> bombService.throwBomb(BombType.EVENT_LISTENER));
    }

    @Test
    void transactionalEventListener_throw_notPropagate() {
        assertDoesNotThrow(() -> bombService.throwBomb(BombType.TRANSACTIONAL_EVENT_LISTENER));
    }

    @Test
    void asyncEventListener_throw_notPropagate() throws InterruptedException {
        assertDoesNotThrow(() -> bombService.throwBomb(BombType.ASYNC_EVENT_LISTENER));
        Thread.sleep(2000);
    }

    @Test
    void asyncTransactionalEventListener_throw_notPropagate() throws InterruptedException {
        assertDoesNotThrow(() -> bombService.throwBomb(BombType.ASYNC_TRANSACTIONAL_EVENT_LISTENER));
        Thread.sleep(2000);
    }

}
