package lotto.domain;

import lotto.util.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
    @DisplayName("마켓에서 로또를 구매할 수 있다")
    @Test
    void buy_lotto_test() {
        List<LottoTicket> tickets = LottoMarket.sell(10_000, new RandomLottoGenerator());
        assertThat(tickets).hasSize(10);
    }
}
