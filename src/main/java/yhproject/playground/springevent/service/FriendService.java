package yhproject.playground.springevent.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yhproject.playground.springevent.entity.Friend;
import yhproject.playground.springevent.event.CreatedFriendEvent;
import yhproject.playground.springevent.repository.FriendRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRepository friendRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public String saveAndGetHelloMessage(String name) {
        Friend friend = friendRepository.save(Friend.builder()
                .name(name)
                .build());
        eventPublisher.publishEvent(new CreatedFriendEvent(friend.getId(), System.currentTimeMillis()));
        return "Hello, %s. your id is %s.".formatted(friend.getName(), friend.getId());
    }

}
