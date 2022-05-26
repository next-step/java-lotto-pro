package lotto.domain;

import lotto.domain.error.PayAmountErrorCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PayAmountTest {

    private static final int MIN_PAY_AMOUNT = 1000;

    @Test
    @DisplayName("payAmount의 최소값 1000 보다 작은값 입력 시 에러발생")
    public void payAmount_최소값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(999);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(
                        String.format(PayAmountErrorCode.ALLOW_MIN_PAY_AMOUNT.getMessage(), MIN_PAY_AMOUNT));
    }

    @Test
    @DisplayName("payAmount가 integer 범위를 넘어가면 에러발생")
    public void payAmount_최대값() throws Exception {
        assertThatThrownBy(() -> {
            new PayAmount(Integer.MAX_VALUE + 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("lottoCount 입력 시 payAmount 계산이 정확한지 테스트")
    public void calculate() throws Exception {
        int lottoCount = 1;
        int payAmount = PayAmount.calculate(new LottoCount(lottoCount));

        assertThat(payAmount).isEqualTo(lottoCount * MIN_PAY_AMOUNT);
    }

    @Test
    @DisplayName("자동으로 구매할 티켓 카운트를 계산한다.")
    public void calculateAutoLottoCount() throws Exception {
        LottoCount manualLottoCount = new LottoCount(1);
        PayAmount payAmount = new PayAmount(10000);

        Assertions.assertThat(payAmount.calculateAutoLottoCount(manualLottoCount)).isEqualTo(new LottoCount(9));
    }
}