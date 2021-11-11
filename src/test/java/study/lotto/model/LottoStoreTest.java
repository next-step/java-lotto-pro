package study.lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoStoreTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "13200:13", "1900:1", "1000:1"}, delimiterString = ":")
    void 천원당_로또_한개를_구매할_수_있다(final int money, final int expectedCountOfTicket) {
        final OrderResult orderResult = LottoStore.getInstance().orderAutoTicketLotteryBundle(Money.valueOf(money));
        assertThat(orderResult.size()).isEqualTo(expectedCountOfTicket);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 1001, 1002})
    void 천원_이상일_경우_자동_로또복권을_구매할_수_있다(final int money) {
        assertThat(LottoStore.getInstance().orderAutoTicketAble(Money.valueOf(money))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 999, 112})
    void 천원_미만일_경우_자동_로또복권을_구매할_수_없다(final int money) {
        assertThat(LottoStore.getInstance().orderAutoTicketAble(Money.valueOf(money))).isFalse();
    }

    @Test
    void 수동_로또복권의_개수와_금액에따라_수동복권을_살수_있는지_확인할_수_있다() {
        final OrderManualTicketLotteryBundle orderManualTicketLotteryBundle = OrderManualTicketLotteryBundle.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 22, 33))
        ));
        final LottoStore lottoStore = LottoStore.getInstance();

        assertAll(() -> {
            assertThat(lottoStore.orderManualTicketAble(orderManualTicketLotteryBundle, Money.valueOf(1000))).isFalse();
            assertThat(lottoStore.orderManualTicketAble(orderManualTicketLotteryBundle, Money.valueOf(2000))).isFalse();
            assertThat(lottoStore.orderManualTicketAble(orderManualTicketLotteryBundle, Money.valueOf(3000))).isTrue();
            assertThat(lottoStore.orderManualTicketAble(orderManualTicketLotteryBundle, Money.valueOf(4000))).isTrue();
        });
    }

    @Test
    void 주문금액_만큼_자동로또복권을_구매할_수_있다() {
        final LottoStore lottoStore = LottoStore.getInstance();
        final OrderResult orderResult = lottoStore.orderAutoTicketLotteryBundle(Money.valueOf(3000));
        assertThat(orderResult.size()).isEqualTo(3);
    }

    @Test
    void 작성한_수동로또복권만큼_구매할_수_있다() {
        final LottoStore lottoStore = LottoStore.getInstance();
        final OrderManualTicketLotteryBundle orderManualTicketLotteryBundle = OrderManualTicketLotteryBundle.valueOf(Arrays.asList(
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new HashSet<>(Arrays.asList(1, 2, 3, 4, 22, 33))
        ));
        final OrderResult orderResult = lottoStore.orderManualTicketLotteryBundle(orderManualTicketLotteryBundle);
        assertThat(orderResult.size()).isEqualTo(3);
    }
}