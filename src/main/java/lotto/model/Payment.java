package lotto.model;

import java.util.Objects;

public class Payment {
    static final int LOTTO_PRICE = 1000;
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
        return new LottoCount(manualCount, payment / LOTTO_PRICE);
    }

    public RateOfReturn computeRateOfReturn(int prizeMoney) {
        return new RateOfReturn((double)prizeMoney / payment);
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
