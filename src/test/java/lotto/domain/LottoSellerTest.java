package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSellerTest {
    @DisplayName("구입 금액만큼 가능한 개수 확인")
    @Test
    void test_자동_로또_구입_개수() {
        //given
        Money money = Money.from(5500);
        //when
        LottoTickets lottoTickets = LottoSeller.create().autoLottoTickets(money);
        //then
        assertThat(lottoTickets.size()).isEqualTo(5);
    }

    @DisplayName("최소 구입 금액 미만의 값 입력 시 예외 처리")
    @Test
    void test_최소_구입_금액_오류() {
        //given
        Money money = Money.from(500);
        //when & then
        assertThatThrownBy(() -> LottoSeller.create().autoLottoTickets(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THEN_PRICE_MONEY);
    }
}