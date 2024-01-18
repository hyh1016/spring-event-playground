package yhproject.playground.springevent.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ErrorHandler;

@Slf4j
@Component
public class EventListenerExceptionHandler implements ErrorHandler {

    @Override
    public void handleError(Throwable t) {
        log.error("이벤트 리스너 실행 중 예외 발생", t);
    }

}
