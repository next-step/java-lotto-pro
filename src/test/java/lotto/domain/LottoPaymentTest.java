package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPaymentTest {
    @Test
    @DisplayName("지불 금액을 파라미터로 Payment 객체가 생성되어야 한다")
    void create() {
        // given
        final int money = 1000;

        // when
        final LottoPayment lottoPayment = new LottoPayment(money);

        // when and then
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(money));
    }

    @Test
    @DisplayName("지불 금액 문자열을 파라미터로 Payment 객체가 생성되어야 한다")
    void convert_and_create() {
        // given
        final String money = "1000";

        // when
        final LottoPayment lottoPayment = LottoPayment.convertAndCreate(money);

        // when and then
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(1000));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "14000:14", "1000000:1000"}, delimiter = ':')
    @DisplayName("구매 가능 수량은 티켓 가격과 연동되어야 한다")
    void purchasable_amount_should_match_ticket_cost(final int money, final int expected) {
        // when and then
        assertThat(new LottoPayment(money).getPurchasableAmount()).isEqualTo(expected);
    }
}
