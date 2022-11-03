package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PayAmountTest {
    @Test
    @DisplayName("입력한 금액으로 구매가능한 로또 갯수 테스트")
    public void lottoAmountTest() {
        PayAmount payAmount = new PayAmount(3500);
        assertThat(payAmount.lottoAmount()).isEqualTo(3);
    }
}