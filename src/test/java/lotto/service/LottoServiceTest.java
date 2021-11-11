package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.exception.NotEnoughMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {

    @Test
    @DisplayName("구입한 로또의 개수를 확인한다")
    void buyLottosTest() {
        LottoService lottoService = new LottoService();
        LottoTickets lottos = lottoService.buyAutoLottoTickets(1);

        assertThat(lottos.count()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동 및 수동 로또의 개수를 구한다")
    void getCountsOfLottoTicketsTest() {
        // given
        LottoService lottoService = new LottoService();

        // when
        int countsOfAutoTickets = lottoService.getCountsOfAutoTickets(new Money(11001), 5);

        // then
        assertThat(countsOfAutoTickets).isEqualTo(6);
    }

    @Test
    @DisplayName("돈이 부족할 때 예외를 던진다")
    void notEnoughMoneyTest() {
        LottoService lottoService = new LottoService();
        // given, when
        assertThatThrownBy(() -> lottoService.getCountsOfAutoTickets(new Money(10000), 11))
                // then
                .isInstanceOf(NotEnoughMoneyException.class);
    }
}