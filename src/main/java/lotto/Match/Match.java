package lotto.Match;

public enum Match {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int amount;

    Match(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public int getCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }

}
