package lotto;

public enum LottoMatchType {
    OTHER(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private final int winningAmount;

    LottoMatchType(int winningAmount) {
        this.winningAmount = winningAmount;
    }
}
