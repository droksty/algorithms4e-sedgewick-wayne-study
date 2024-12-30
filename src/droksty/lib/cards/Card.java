package droksty.lib.cards;

/**
 * A playing card.
 */
public final class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank.value + " of " + suit.value;
    }
}
