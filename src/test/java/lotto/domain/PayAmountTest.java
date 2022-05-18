package lotto.domain;

import lotto.infrastructure.error.PayAmountErrorCode;
import org.assertj.core.api.Assertions;
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

    @Test
    public void payAmount_최대값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(String.valueOf(Long.MAX_VALUE));
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    public void calculate() throws Exception {
        int lottoCount = 1;
        int payAmount = PayAmount.calculate(new LottoCount(lottoCount));

        Assertions.assertThat(payAmount).isEqualTo(lottoCount * MIN_PAY_AMOUNT);
    }
}