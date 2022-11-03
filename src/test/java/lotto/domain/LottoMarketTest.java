package lotto.domain;

import lotto.constant.LOTTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMarketTest {
    @DisplayName("마켓에서 로또를 구매할 수 있다")
    @Test
    void buy_lotto_test() {
        LottoMarket lottoMarket = new LottoMarket(new Money(LOTTO.PRICE), new RandomLottoGenerator());
        List<LottoTicket> tickets = lottoMarket.sell(new Money(10_000L), Collections.emptyList());
        assertThat(tickets).hasSize(10);
    }

    @DisplayName("수동으로 입력한 값으로 로또를 구매할 수 있다")
    @Test
    void buy_manual_lotto_test() {
        LottoMarket lottoMarket = new LottoMarket(new Money(LOTTO.PRICE), new RandomLottoGenerator());
        List<LottoTicket> tickets = lottoMarket.sell(new Money(1_000L), Arrays.asList("1,2,3,4,5,6"));
        LottoTicket manualTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();

        assertThat(tickets.get(0).equals(manualTicket)).isTrue();
    }

    @DisplayName("수동 구매한 로또가 먼저 발권된다")
    @Test
    void lotto_order_test() {
        LottoMarket lottoMarket = new LottoMarket(new Money(LOTTO.PRICE), new RandomLottoGenerator());
        List<LottoTicket> tickets = lottoMarket.sell(new Money(5_000L), Arrays.asList("1,2,3,4,5,6"));
        LottoTicket manualTicket = new ManualLottoGenerator(Arrays.asList(1, 2, 3, 4, 5, 6)).create();

        assertThat(tickets.get(0).equals(manualTicket)).isTrue();
    }
}
