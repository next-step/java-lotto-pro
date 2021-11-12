package lotto.domain;

public class PrizeMoney {

    private long amount;

    public PrizeMoney(long defaultPrizeMoney) {
        if (defaultPrizeMoney < 0) {
            throw new IllegalArgumentException("상금은 0원 이상입니다.");
        }
        this.amount = defaultPrizeMoney;
    }

    public void prizeMoneyAccumulate(int winningCount) {
        if (winningCount >= 0) {
            this.amount = this.amount * winningCount;
        }
    }

    public long profitRate(int purchaseAmount) {
        return this.amount / purchaseAmount;
    }
}
