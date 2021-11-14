package lotto.model;

import java.util.Objects;

public class Payment {
    static final int LOTTO_PRICE = 1000;
    static final String NEGATIVE_MANUAL_COUNT_ERR_MSG = "수동으로 구매할 로또의 수가 음수일 수 없습니다.";
    static final String NEGATIVE_WINNING_MONEY_ERR_MSG = "당첨금액은 음수일 수 없습니다.";
    private static final String MIN_MONEY_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.";
    private static final String MONEY_MULTIPLE_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "의 배수여야 합니다.";

    private final int payment;

    public Payment(int payment) {
        this.payment = payment;
        validate();
    }

    private void validate() {
        if (payment < LOTTO_PRICE) {
            throw new IllegalArgumentException(MIN_MONEY_ERR_MSG);
        }
        if (payment % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_MULTIPLE_ERR_MSG);
        }
    }

    public LottoCount computeLottoCount(int manualCount) {
        if (manualCount < 0) {
            throw new IllegalArgumentException(NEGATIVE_MANUAL_COUNT_ERR_MSG);
        }
        return new LottoCount(manualCount, payment / LOTTO_PRICE);
    }

    public RateOfReturn computeRateOfReturn(int winningMoney) {
        if (winningMoney < 0) {
            throw new IllegalArgumentException(NEGATIVE_WINNING_MONEY_ERR_MSG);
        }
        return new RateOfReturn((double)winningMoney / payment);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Payment other = (Payment)obj;
        return this.payment == other.payment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(payment);
    }
}
