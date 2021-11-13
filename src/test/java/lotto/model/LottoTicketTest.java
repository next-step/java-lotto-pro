package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {
    @Test
    void of_6개성공() {
        final LottoTicket ticket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(ticket).isNotNull();
        assertThat(ticket).isInstanceOf(LottoTicket.class);
    }

    @Test
    void of_7개실패() {
        assertThatThrownBy(() -> LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void countPurchasable_1장() {
        final Money price = new Money(1_000);
        final int count = LottoTicket.countPurchasable(price);
        assertThat(count).isEqualTo(1);
    }

    @Test
    void countPurchasable_0원() {
        final Money price = new Money(0);
        final int count = LottoTicket.countPurchasable(price);
        assertThat(count).isEqualTo(0);
    }

    @Test
    void countPurchasable_딱떨어지지않음() {
        final Money price = new Money(1_500);
        final int count = LottoTicket.countPurchasable(price);
        assertThat(count).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("provideWinTicket")
    void calculateNumberOfMatch(LottoTicket winLottoTicket, int expectedNumberOfMatch) {
        final LottoTicket buyTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(buyTicket.calculateNumberOfMatch(winLottoTicket))
                .isEqualTo(expectedNumberOfMatch);
    }

    private static Stream<Arguments> provideWinTicket() {
        return Stream.of(
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(LottoTicket.of(Arrays.asList(11, 12, 13, 14, 15, 16)), 0),
                Arguments.of(LottoTicket.of(Arrays.asList(1, 2, 13, 14, 15, 16)), 2)
        );
    }
}
