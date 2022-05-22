package lotto.domain;

import lotto.exception.LottoPaymentException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPaymentTest {

    @Test
    @DisplayName("구입금액이 정상입력된 경우 맞는 구입금액이 생성되어야 한다.")
    void 구입금액_정상() {
        Assertions.assertThat(new LottoPayment(14000).toLottoPaymentDTO().getTotalPayment())
            .isEqualTo(14000);
    }

    @Test
    @DisplayName("구입금액이 음수인 경우 예외가 발생되어야 한다.")
    void 구입금액_음수_예외() {
        Assertions.assertThatThrownBy(() -> new LottoPayment(-1))
            .isInstanceOf(LottoPaymentException.class);
    }

    @Test
    @DisplayName("구입금액에 맞게 로또개수가 계산되어야 한다.")
    void 구입_로또개수_테스트() {
        LottoPayment lottoPayment = new LottoPayment(14000);
        Assertions.assertThat(lottoPayment.getLottoLineCount()).isEqualTo(14);
    }

}