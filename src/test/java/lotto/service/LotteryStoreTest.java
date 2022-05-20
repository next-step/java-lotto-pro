package lotto.service;

import lotto.model.Lotteries;
import lotto.model.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {
    @ParameterizedTest
    @MethodSource("로또_교환_쿠폰")
    void 로또_교환(Money money, int buyCount) {
        Lotteries lotteries = LotteryStore.exchangeTicketToLotteries(LotteryClerk.exchangeTicket(money));
        assertThat(lotteries.list()).hasSize(buyCount);
    }

    static Stream<Arguments> 로또_교환_쿠폰() {
        return Stream.of(
                Arguments.of(new Money(1000), 1),
                Arguments.of(new Money(10000), 10),
                Arguments.of(new Money(100000), 100)
        );
    }
}