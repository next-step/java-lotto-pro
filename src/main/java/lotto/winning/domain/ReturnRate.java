package lotto.winning.domain;

import lotto.lotto.domain.LottoMoney;

public class ReturnRate {

    private final LottoMoney lottoMoney;
    private final TotalWinningMoney totalWinningMoney;

    public ReturnRate(LottoMoney lottoMoney, TotalWinningMoney totalWinningMoney) {
        this.lottoMoney = lottoMoney;
        this.totalWinningMoney = totalWinningMoney;
    }

    public double calculate() {
        return (double) totalWinningMoney.sum() / (double) lottoMoney.getNumber();
    }
}
