package yhproject.playground.springevent.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

@Slf4j
@Configuration
public class EventConfig {

    @Bean
    public ApplicationEventMulticaster applicationEventMulticaster(EventListenerExceptionHandler exceptionHandler) {
        SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setErrorHandler(exceptionHandler);
        return multicaster;
    }

}
