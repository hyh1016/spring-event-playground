package yhproject.playground.springevent.config;

import org.springframework.context.ApplicationListener;
import org.springframework.transaction.event.TransactionalApplicationListener;
import org.springframework.transaction.event.TransactionalApplicationListener.SynchronizationCallback;
import org.springframework.transaction.event.TransactionalEventListenerFactory;

import java.lang.reflect.Method;
import java.util.List;

public class CustomTransactionalEventListenerFactory extends TransactionalEventListenerFactory {

    private final List<SynchronizationCallback> callbackList;

    public CustomTransactionalEventListenerFactory(List<SynchronizationCallback> synchronizationCallbacks,
                                                   int order) {
        super();
        super.setOrder(order);
        this.callbackList = synchronizationCallbacks;
    }

    @Override
    public ApplicationListener<?> createApplicationListener(String beanName, Class<?> type, Method method) {
        ApplicationListener<?> applicationListener = super.createApplicationListener(beanName, type, method);
        if (applicationListener instanceof TransactionalApplicationListener<?> listener) {
            callbackList.forEach(listener::addCallback);
        }
        return applicationListener;
    }

}
