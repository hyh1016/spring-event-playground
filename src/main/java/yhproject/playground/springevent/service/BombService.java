package yhproject.playground.springevent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhproject.playground.springevent.constants.BombType;
import yhproject.playground.springevent.event.BombEvent;

@Slf4j
@Service
@RequiredArgsConstructor
public class BombService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void throwBomb(BombType bombType) {
        eventPublisher.publishEvent(new BombEvent(bombType, System.currentTimeMillis()));
    }

}
