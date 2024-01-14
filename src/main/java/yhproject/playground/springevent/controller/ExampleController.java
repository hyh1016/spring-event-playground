package yhproject.playground.springevent.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yhproject.playground.springevent.service.FriendService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ExampleController {

    private final FriendService friendService;

    @GetMapping(value = "/hello", params = "name")
    public ResponseEntity<String> publishEvent(@RequestParam(defaultValue = "anonymous") String name) {
        log.info("[POST] hello {}", name);
        return ResponseEntity.ok(friendService.saveAndGetHelloMessage(name));
    }

}
