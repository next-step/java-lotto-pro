package lotto.domain;

import lotto.infrastructure.error.PayAmountErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PayAmountTest {

    private static final int MIN_PAY_AMOUNT = 1000;

    @ParameterizedTest
    @NullAndEmptySource
    public void payAmount_null_or_empty(String payAmount) throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(payAmount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PayAmountErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    public void payAmount_문자() throws Exception {
        String payAmount = "aa";

        assertThatThrownBy(() -> {
            new PayAmount(payAmount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(PayAmountErrorCode.ONLY_ALLOW_POSITIVE_NUMBER.getMessage(), payAmount));
    }

    @Test
    public void payAmount_음수() throws Exception {
        String payAmount = "-1";

        assertThatThrownBy(() -> {
            new PayAmount(payAmount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(PayAmountErrorCode.ONLY_ALLOW_POSITIVE_NUMBER.getMessage(), payAmount));
    }

    @Test
    public void payAmount_최소값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount("999");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
    }
}