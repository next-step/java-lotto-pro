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
        LottoTickets lottos = lottoService.buyLottoTickets(new Money(1000));

        assertThat(lottos.count()).isEqualTo(1);
    }
}