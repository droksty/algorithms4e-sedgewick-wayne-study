package droksty.lib.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A {@link BridgeHand} consists of 13 droksty.lib.cards and is designated by a cardinal direction.
 */
public final class BridgeHand {
    private final String direction;
    Card[] cards;

    public BridgeHand(String direction) {
        this.direction = direction;
        cards = new Card[13];
    }

    public String getDirection() {
        return direction;
    }
    public Set<Card> getCards() {
        return Collections.unmodifiableSet(Arrays.stream(cards).collect(Collectors.toSet()));
    }
}
