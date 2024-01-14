package yhproject.playground.springevent.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;
import yhproject.playground.springevent.entity.Friend;
import yhproject.playground.springevent.repository.FriendRepository;

import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class GreetedEventListener {

    private final FriendRepository friendRepository;

    @EventListener
    public void logGreetedEvent(CreatedFriendEvent event) {
        log.info("[friend ID: {}] 동기 이벤트 리스너 호출", event.friendId());
        // 친구를 찾을 수 있다. (동일 트랜잭션)
        findAndLogging("동기 이벤트 리스너", event.friendId());
    }

    @Async("customExecutor")
    @EventListener
    public void logGreetedEventAsynchronously(CreatedFriendEvent event) {
        log.info("[friend ID: {}] 비동기 이벤트 리스너 호출", event.friendId());
        // 친구를 찾을 수도, 아닐 수도 있다. (트랜잭션 커밋 시점에 따라 다름)
        findAndLogging("비동기 이벤트 리스너", event.friendId());
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @TransactionalEventListener
    public void updateEntity(CreatedFriendEvent event) {
        log.info("[friend ID: {}] 동기 트랜잭셔널 이벤트 리스너 호출", event.friendId());
        // 친구를 찾을 수 있다. (커밋 이후 조회)
        findAndLogging("동기 트랜잭셔널 이벤트 리스너", event.friendId());
    }

    @Async("customExecutor")
    @TransactionalEventListener
    public void updateEntityAsynchronously(CreatedFriendEvent event) {
        log.info("[friend ID: {}] 비동기 트랜잭셔널 이벤트 리스너 호출", event.friendId());
        // 친구를 찾을 수 있다. (커밋 이후 조회)
        findAndLogging("비동기 트랜잭셔널 이벤트 리스너", event.friendId());
    }

    private void findAndLogging(String listenerName, long friendId) {
        Optional<Friend> friendOptional = friendRepository.findById(friendId);
        if (friendOptional.isPresent()) {
            Friend friend = friendOptional.get();
            log.info("[listener: {}] 친구 {} 찾았다!", listenerName, friend.getName());
        } else {
            log.info("[listener: {}] id가 {}인 친구가 없다.", listenerName, friendId);
        }
    }

}
