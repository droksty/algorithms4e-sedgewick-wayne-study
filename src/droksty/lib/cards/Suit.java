package droksty.lib.cards;

/**
 * The 4 French suites.
 */
public enum Suit {
    SPADES("Spades"),
    DIAMONDS("Diamonds"),
    CLUBS("Clubs"),
    HEARTS("Hearts")
    ;

    Suit(String value) {
        this.value = value;
    }

    final String value;
}
