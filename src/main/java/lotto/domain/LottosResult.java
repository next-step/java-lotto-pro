package lotto.domain;

public class LottosResult {
    private final int purchaseMoney;
    private long returnMoney;

    public LottosResult(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
        returnMoney = 0;
    }

    public void plusReturnMoney(long winnerMoney) {
        returnMoney += winnerMoney;
    }

    public float ratio() {
        return (float) returnMoney / purchaseMoney;
    }
}
