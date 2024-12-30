package droksty.lib.cards;

/**
 * The 13 ranks of a standard 52-card French-suited deck.
 */
public enum Rank {
    ACE("A"),
    TWO("2"), THREE("3"), FOUR("4"),
    FIVE("5"), SIX("6"), SEVEN("7"),
    EIGHT("8"), NINE("9"), TEN("10"),
    JACK("J"), QUEEN("Q"), KING("K");

    Rank(String value) {
        this.value = value;
    }

    final String value;
}
