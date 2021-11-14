package lotto.domain;

public enum Prize {
    FIRST(6, new Price(2_000_000_000L)),
    SECOND(5, new Price(30_000_000L)),
    THIRD(5, new Price(1_500_000L)),
    FOURTH(4, new Price(50_000L)),
    FIFTH(3, new Price(5_000L)),
    NONE(0, new Price(0L));

    private final int matchCount;
    private final Price amount;

    Prize(final int matchCount, final Price amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Price getAmount() {
        return amount;
    }

    public String getAmountAsString() {
        return amount.asString();
    }
}
