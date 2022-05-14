package lotto;

public enum WinningRank {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000);

    private final Integer price;

    WinningRank(Integer price) {
        this.price = price;
    }

    public static WinningRank getWinningRank(int matchCount) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5) {
            return SECOND;
        }
        if (matchCount == 4) {
            return THIRD;
        }
        if (matchCount == 3) {
            return FOURTH;
        }
        return null;
    }
}
