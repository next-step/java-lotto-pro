package lotto.winning.domain;

import lotto.lotto.domain.LottoMoney;

import java.util.Objects;

public class ReturnRate {

    public static final String LOTTO_MONEY_EXCEPTION_MESSAGE = "로또 구매 금액이 없습니다.";
    public static final String TOTAL_WINNING_MONEY_EXCEPTION_MESSAGE = "당첨 금액이 없습니다.";
    private final LottoMoney lottoMoney;
    private final TotalWinningMoney totalWinningMoney;

    public ReturnRate(LottoMoney lottoMoney, TotalWinningMoney totalWinningMoney) {
        validate(lottoMoney, totalWinningMoney);
        this.lottoMoney = lottoMoney;
        this.totalWinningMoney = totalWinningMoney;
    }

    private void validate(LottoMoney lottoMoney, TotalWinningMoney totalWinningMoney) {
        if (Objects.isNull(lottoMoney)) {
            throw new IllegalArgumentException(LOTTO_MONEY_EXCEPTION_MESSAGE);
        }
        if (Objects.isNull(totalWinningMoney)) {
            throw new IllegalArgumentException(TOTAL_WINNING_MONEY_EXCEPTION_MESSAGE);
        }
    }

    public double calculate() {
        return (double) totalWinningMoney.sum() / (double) lottoMoney.getNumber();
    }
}
