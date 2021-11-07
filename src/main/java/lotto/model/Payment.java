package lotto.model;

import java.util.Objects;

import lotto.exception.BadRequestException;

public class Payment {
    public static final int LOTTO_PRICE = 1000;
    private static final String MIN_MONEY_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "원 이상이어야 합니다.";
    private static final String MONEY_MULTIPLE_ERR_MSG = "구입 금액은 " + LOTTO_PRICE + "의 배수여야 합니다.";

    private final int payment;

    public Payment(int payment) {
        this.payment = payment;
        validate();
    }

    private void validate() {
        if (payment < LOTTO_PRICE) {
            throw new BadRequestException(MIN_MONEY_ERR_MSG);
        }
        if (payment % LOTTO_PRICE != 0) {
            throw new BadRequestException(MONEY_MULTIPLE_ERR_MSG);
        }
    }

    public int getLottoCount() {
        return payment / LOTTO_PRICE;
    }

    public double getRateOfReturn(int prizeMoney) {
        return ((double)prizeMoney) / payment;
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
