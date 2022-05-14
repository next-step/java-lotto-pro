package lotto.enums;

public enum LottoWinningType {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(-1,0);

    private int matchedCount;
    private int price;

    LottoWinningType(int matchedCount, int price) {
        this.matchedCount = matchedCount;
        this.price = price;
    }
}
