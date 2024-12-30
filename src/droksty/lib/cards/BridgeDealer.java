package droksty.lib.cards;


import droksty.collections.RandomQueue;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Deals droksty.lib.cards for a game of bridge.
 */
public final class BridgeDealer {

    private BridgeDealer() {}

    /**
     * Deal the droksty.lib.cards.
     * @param deck   The standard 52-card deck to deal.
     * @return  The set of the 4 {@link BridgeHand BridgeHand(s)} dealt.
     */
    public static Set<BridgeHand> deal(RandomQueue<Card> deck) {
        Set<BridgeHand> hands = initializeSet();
        for (int i = 0; i < Rank.values().length; i++) {
            for (BridgeHand hand : hands) {
                hand.cards[i] = deck.dequeue();
            }
        }
        return Collections.unmodifiableSet(hands);
    }

    // Helper
    private static Set<BridgeHand> initializeSet() {
        Set<BridgeHand> hands = new HashSet<>();
        hands.add(new BridgeHand("NORTH"));
        hands.add(new BridgeHand("EAST"));
        hands.add(new BridgeHand("SOUTH"));
        hands.add(new BridgeHand("WEST"));
        return hands;
    }
}
