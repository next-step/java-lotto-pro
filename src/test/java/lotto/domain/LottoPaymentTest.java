package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPaymentTest {
    @Test
    @DisplayName("지불 금액과 구매 가능 수량을 파라미터로 Payment 객체가 생성되어야 한다")
    void create() {
        // given
        final int money = 1000;
        final int purchasableAmount = 1;

        // when
        final LottoPayment lottoPayment = new LottoPayment(money, purchasableAmount);

        // when and then
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(money, purchasableAmount));
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
        assertThat(lottoPayment).isEqualTo(new LottoPayment(1000, 1));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1", "2000:2", "14000:14", "1000000:1000"}, delimiter = ':')
    @DisplayName("구매 가능 수량은 티켓 가격과 연동되어야 한다")
    void purchasable_amount_should_match_ticket_cost(final int money, final int expected) {
        // when and then
        assertThat(LottoPayment.convertAndCreate(String.valueOf(money)).getPurchasableAmount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수동 구매 수량을 문자열 파라미터로 설정할 수 있어야 한다")
    void can_set_manual_amount() {
        // given
        final LottoPayment lottoPayment = LottoPayment.convertAndCreate("14000");
        final String manualAmountString = "3";

        // when
        lottoPayment.setManualAmount(manualAmountString);

        // then
        assertThat(lottoPayment.getManualAmount()).isEqualTo(3);
    }
}
