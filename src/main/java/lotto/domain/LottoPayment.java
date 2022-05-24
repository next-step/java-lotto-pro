package lotto.domain;

import java.util.Objects;
import lotto.dto.LottoPaymentDTO;
import lotto.exception.LottoPaymentException;

public class LottoPayment {

    private static final int LOTTO_PAYMENT_MIN = 0;
    private static final int LOTTO_PRICE_EACH = 1000;
    private final int totalPayment;

    public LottoPayment(int totalPayment) {
        validatePayment(totalPayment);
        this.totalPayment = totalPayment;
    }

    private static void validatePayment(int totalPayment) {
        if (totalPayment < LOTTO_PAYMENT_MIN) {
            throw new LottoPaymentException();
        }
    }

    public LottoPaymentDTO toLottoPaymentDTO() {
        return new LottoPaymentDTO(totalPayment);
    }

    public int getLottoLineCount() {
        return totalPayment / LOTTO_PRICE_EACH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoPayment that = (LottoPayment) o;

        return totalPayment == that.totalPayment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPayment);
    }
}
