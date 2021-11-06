package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoServiceTest {

    @Test
    void buyLottosTest() {
        LottoService lottoService = new LottoService();
        LottoTickets lottos = lottoService.buyLottoTickets(new Money(1000));

        assertThat(lottos.count()).isEqualTo(1);
    }
}