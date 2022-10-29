package enums;

public enum Match {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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
