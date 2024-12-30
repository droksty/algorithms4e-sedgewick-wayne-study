package droksty.solutions.chapter1.section3;

import droksty.collections.RandomQueue;     // ADT developed for this exercise
import droksty.lib.cards.*;                 // ADTs developed for this exercise

import java.util.Set;

// This exercise is an opportunity to practice OOP.
public class Exercise35 {
    private static RandomQueue<Card> getStandardDeck() {
        RandomQueue<Card> standardDeck = new RandomQueue<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                standardDeck.enqueue(new Card(suit, rank));
            }
        }
        return standardDeck;
    }

    public static void main(String[] args) {
        RandomQueue<Card> standardDeck = getStandardDeck();
        Set<BridgeHand> hands = BridgeDealer.deal(standardDeck);

        // Print results
        for (BridgeHand hand : hands) {
            System.out.println("[ " + hand.getDirection() + " ]");
            for (Card card : hand.getCards()) {
                System.out.println(card);
            }
            System.out.println();
        }
    }
}
