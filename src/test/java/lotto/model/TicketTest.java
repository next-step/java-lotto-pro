package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TicketTest {
    @ParameterizedTest()
    @MethodSource("money")
    void exchange(Money money, int size) {
        assertThat(new Ticket(money).size()).isEqualTo(size);
    }

    static Stream<Arguments> money() {
        return Stream.of(
                Arguments.of(new Money(1000), 1),
                Arguments.of(new Money(1500), 1),
                Arguments.of(new Money(10000), 10)
        );
    }

    @Test
    void use() {
        Ticket ticket = new Ticket(new Money(10000));
        ticket.use(5);
        assertThat(ticket.size()).isEqualTo(5);
    }
}