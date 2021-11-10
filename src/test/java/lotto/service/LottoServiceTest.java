package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}