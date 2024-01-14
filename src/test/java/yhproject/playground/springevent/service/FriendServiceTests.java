package yhproject.playground.springevent.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class FriendServiceTests {

    @Autowired
    FriendService friendService;

    @Test
    void sayHello_success() {
        // given
        String name = "yihyun";

        // when
        String helloMessage = friendService.saveAndGetHelloMessage(name);

        // then
        assertTrue(helloMessage.contains("Hello, %s".formatted(name)));
    }

}
