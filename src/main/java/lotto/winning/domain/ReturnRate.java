package lotto.winning.domain;

import lotto.lotto.domain.LottoMoney;

public class ReturnRate {

    private final LottoMoney lottoMoney;
    private final TotalWinningMoney winningMoneyCalculator;

    public ReturnRate(LottoMoney lottoMoney, TotalWinningMoney winningMoneyCalculator) {
        this.lottoMoney = lottoMoney;
        this.winningMoneyCalculator = winningMoneyCalculator;
    }

    public double calculate() {
        return (double) winningMoneyCalculator.sum() / (double) lottoMoney.getNumber();
    }
}
