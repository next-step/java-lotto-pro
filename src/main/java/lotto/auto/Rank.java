package lotto.auto;

public enum Rank {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int match;
    private final int money;

    Rank(int match, int money) {
        this.match = match;
        this.money = money;
    }
}
