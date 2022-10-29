package step3;

public enum KoreaLottoScoreType {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    private final int score;
    private final int money;

    KoreaLottoScoreType(int score, int money) {
        this.score = score;
        this.money = money;
    }

    public int getScore() {
        return score;
    }

    public int getMoney() {
        return money;
    }
}
