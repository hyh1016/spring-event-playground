package yhproject.playground.springevent.event;

import yhproject.playground.springevent.constants.BombType;

public record BombEvent(BombType bombType, long timestamp) {

}
