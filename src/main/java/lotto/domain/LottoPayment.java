package lotto.domain;

import java.util.Objects;
import lotto.exception.LottoCountException;
import lotto.exception.LottoPaymentException;

public class LottoPayment {

    private static final int LOTTO_PAYMENT_MIN = 0;
    private static final int LOTTO_PRICE_EACH = 1000;
    private static final int DEFAULT_VALUE = 0;
    private static final String ERROR_LOTTO_TOTAL_PAYMENT_MIN = "[ERROR] 음수는 입력할 수 없습니다.";
    private static final String ERROR_LOTTO_COUNT_LIMIT = "[ERROR] 수동으로 구매할 수 있는 로또 수를 초과하였습니다.";

    private final int totalPayment;

    public LottoPayment(int totalPayment) {
        validatePayment(totalPayment);
        this.totalPayment = totalPayment;
    }

    private static void validatePayment(int totalPayment) {
        if (totalPayment < LOTTO_PAYMENT_MIN) {
            throw new LottoPaymentException(ERROR_LOTTO_TOTAL_PAYMENT_MIN);
        }
    }

    public int countLine() {
        return totalPayment / LOTTO_PRICE_EACH;
    }

    public void validateManualLottoCount(LottoCount lottoCount) {
        int autoCount = countLine() - lottoCount.value();
        if (autoCount < DEFAULT_VALUE) {
            throw new LottoCountException(ERROR_LOTTO_COUNT_LIMIT);
        }
    }

    public int value() {
        return totalPayment;
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
