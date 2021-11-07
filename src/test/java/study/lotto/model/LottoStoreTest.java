package study.lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "13200:13", "1900:1", "1000:1"}, delimiterString = ":")
    void 천원당_로또_한개를_구매할_수_있다(final int money, final int expectedCountOfTicket) {
        final TicketLotteryBundle ticketLotteryBundle = LottoStore.orderTicketLotteryBundleByMoney(Money.valueOf(money));
        assertThat(ticketLotteryBundle.size()).isEqualTo(expectedCountOfTicket);
    }
}