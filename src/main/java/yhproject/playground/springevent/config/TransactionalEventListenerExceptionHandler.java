package yhproject.playground.springevent.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalApplicationListener.SynchronizationCallback;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransactionalEventListenerExceptionHandler implements SynchronizationCallback {

    @Override
    public void postProcessEvent(ApplicationEvent event, Throwable ex) {
        if (ex == null) return;

        log.error("트랜잭셔널 이벤트 리스너 실행 중 예외 발생", ex);
    }
}
