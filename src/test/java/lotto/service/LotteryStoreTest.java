package lotto.service;

import lotto.model.Lotteries;
import lotto.model.Money;
import lotto.model.Ticket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryStoreTest {
    @ParameterizedTest
    @MethodSource("money")
    void exchange(Money money, int buyCount) {
        Lotteries lotteries = LotteryStore.exchangeToLotteries(new Ticket(money));
        assertThat(lotteries.getLotteries()).hasSize(buyCount);
    }

    static Stream<Arguments> money() {
        return Stream.of(
                Arguments.of(new Money(1000), 1),
                Arguments.of(new Money(10000), 10),
                Arguments.of(new Money(100000), 100)
        );
    }
}