package lotto.domain;

import lotto.domain.error.PayAmountErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PayAmountTest {

    private static final int MIN_PAY_AMOUNT = 1000;

    @ParameterizedTest(name = "payAmount가 null 또는 empty인 경우 에러발생")
    @NullAndEmptySource
    public void payAmount_null_or_empty(String payAmount) throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(payAmount);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PayAmountErrorCode.NOT_ALLOW_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("payAmount가 문자인 경우 에러발생")
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
    @DisplayName("payAmount가 음수인 경우 에러발생")
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
    @DisplayName("payAmount의 최소값 1000 보다 작은값 입력 시 에러발생")
    public void payAmount_최소값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount("999");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
    }

    @Test
    @DisplayName("payAmount가 integer 범위를 넘어가면 에러발생")
    public void payAmount_최대값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(String.valueOf(Long.MAX_VALUE));
        }).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("lottoCount 입력 시 payAmount 계산이 정확한지 테스트")
    public void calculate() throws Exception {
        int lottoCount = 1;
        int payAmount = PayAmount.calculate(new LottoCount(lottoCount));

        assertThat(payAmount).isEqualTo(lottoCount * MIN_PAY_AMOUNT);
    }
}