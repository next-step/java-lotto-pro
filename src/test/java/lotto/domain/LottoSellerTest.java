package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoSellerTest {
    @DisplayName("구입 금액만큼 자동 구매 가능한 개수 확인")
    @Test
    void test_로또_자동_구입_개수() {
        //given
        Money money = Money.from(5500);
        //when
        LottoTickets lottoTickets = LottoSeller.create()
                .lottoTickets(money, ManualCount.create(), null);
        //then
        assertThat(lottoTickets.size()).isEqualTo(5);
    }

    @DisplayName("구입 금액만큼 수동 구입했다는 가정하에 자동 구입한 개수 확인")
    @Test
    void test_로또_수동_구입후_자동_개수() {
        //given
        Money money = Money.from(14000);
        ManualCount manualCount = ManualCount.from(3, money);
        //when
        LottoTickets lottoTickets = LottoSeller.create()
                .lottoTickets(money, manualCount, null);
        //then
        assertThat(lottoTickets.size()).isEqualTo(11);
    }

    @DisplayName("로또 수동 구입 후 자동 구입")
    @Test
    void test_로또_수동_구입후_자동_구입() {
        //given
        Money money = Money.from(14000);
        int manualCount = 3;
        LottoTicket lottoTicket = LottoTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoTicket> manualTickets = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            manualTickets.add(lottoTicket);
        }
        //when
        LottoTickets lottoTickets = LottoSeller.create()
                .lottoTickets(money, ManualCount.from(manualCount, money), LottoTickets.from(manualTickets));
        //then
        assertThat(lottoTickets.size()).isEqualTo(14);
        assertThat(lottoTickets.contains(lottoTicket)).isTrue();
    }

    @DisplayName("최소 구입 금액 미만의 값 입력 시 예외 처리")
    @Test
    void test_최소_구입_금액_오류() {
        //given
        Money money = Money.from(500);
        //when & then
        assertThatThrownBy(() -> LottoSeller.create().lottoTickets(money, ManualCount.create(), null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THEN_PRICE_MONEY);
    }

    @DisplayName("수동 구매 개수 null 입력 시 예외 처리")
    @Test
    void test_수동_구매_개수_오류() {
        //given
        Money money = Money.from(1000);
        //when & then
        assertThatThrownBy(() -> LottoSeller.create().lottoTickets(money, null, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LESS_THEN_MANUAL_COUNT);
    }
}