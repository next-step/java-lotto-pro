package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPaymentTest {
    @Test
    @DisplayName("지불 금액을 파라미터로 Payment 객체가 생성되어야 한다")
    void create() {
        // given
        final String money = "1000";

        // when
        final LottoPayment lottoPayment = new LottoPayment(money);

        // when and then
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(money));
    }

    @Test
    @DisplayName("지불 금액이 숫자가 아니면 IllegalArgumentException을 발생시킨다")
    void when_money_is_not_a_number_should_throw_IllegalArgumentException() {
        // given
        final String money = "money";

        // when and then
        assertThatThrownBy(() -> new LottoPayment(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1000", "900", "1900"})
    @DisplayName("지불 금액이 1000원 단위가 아니면 IllegalArgumentException을 발생시킨다")
    void when_amount_of_money_is_invalid_should_throw_IllegalArgumentException(final String money) {
        // when and then
        assertThatThrownBy(() -> new LottoPayment(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "5000:5", "14000:14", "90000:90"}, delimiter = ':')
    @DisplayName("getPurchasableAmount 메서드 호출 시 구매 금액에 맞는 로또 티켓 수량이 반환되어야 한다")
    void when_call_getPurchasableAmount_should_return_correct_purchasable_amount_of_lotto_tickets(final String money, final int expected) {
        // given
        final LottoPayment lottoPayment = new LottoPayment(money);

        // when and then
        assertThat(lottoPayment.getPurchasableAmount()).isEqualTo(expected);
    }
}
