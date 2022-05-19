package lotto;

import lotto.domain.Ticket;
import lotto.domain.Money;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryClerkTest {
    @ParameterizedTest
    @MethodSource("로또_구입_금액")
    void 로또_교환_쿠폰_개수(Money money, Ticket ticket) {
        assertThat(LotteryClerk.exchangeTicket(money)).isEqualTo(ticket);
    }

    static Stream<Arguments> 로또_구입_금액() {
        return Stream.of(
                Arguments.of(new Money(1000), new Ticket(new Money(1000))),
                Arguments.of(new Money(10000), new Ticket(new Money(10000))),
                Arguments.of(new Money(100000), new Ticket(new Money(100000)))
        );
    }
}