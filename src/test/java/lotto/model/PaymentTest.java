package lotto.model;

import static lotto.model.Payment.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTest {
    @ParameterizedTest
    @DisplayName("지불 금액이 " + LOTTO_PRICE + "원 미만이거나 " + LOTTO_PRICE + "으로 나누어 떨어지지 않을 때 예외 발생")
    @ValueSource(ints = {LOTTO_PRICE - 1, LOTTO_PRICE + 1})
    void 객체_생성_시_유효성_검사(int payment) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Payment(payment));
    }

    @Test
    @DisplayName("구매금액과 수동으로 구매할 로또의 수가 주어졌을 때 적절한 로또의 갯수를 반환하는지 테스트")
    void computeLottoCount() {
        Payment payment = new Payment(14000);
        LottoCount lottoCount = payment.computeLottoCount(3);
        assertThat(lottoCount).isEqualTo(new LottoCount(3, 14000 / LOTTO_PRICE));
    }

    @Test
    @DisplayName("수동으로 구매할 로또의 수가 음수로 주어졌을 때 예외 발생")
    void computeLottoCountByNegativeManualCount() {
        Payment payment = new Payment(14000);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> payment.computeLottoCount(-1));
    }

    @Test
    @DisplayName("당첨금액이 주어졌을 때 적절한 수익률을 반환하는지 테스트")
    void computeRateOfReturn() {
        Payment payment = new Payment(14000);
        RateOfReturn rateOfReturn = payment.computeRateOfReturn(30000);
        assertThat(rateOfReturn).isEqualTo(new RateOfReturn((double)30000 / 14000));
    }

    @Test
    @DisplayName("당첨금이 음수로 주어졌을 때 예외 발생")
    void computeRateOfReturnByNegativePrizeMoney() {
        Payment payment = new Payment(14000);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> payment.computeRateOfReturn(-1));
    }

    @Test
    @DisplayName("동등성 검사")
    void equals() {
        Payment expected = new Payment(14000);
        Payment actual = new Payment(14000);
        assertThat(actual).isEqualTo(expected);
    }
}
