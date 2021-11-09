package lotto.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    @ParameterizedTest
    @MethodSource("provideWinTicket")
    void calculateNumberOfMatch(WinTicket winTicket, int expectedNumberOfMatch) {
        final LottoTicket buyTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(buyTicket.calculateNumberOfMatch(winTicket))
                .isEqualTo(expectedNumberOfMatch);
    }

    private static Stream<Arguments> provideWinTicket() {
        return Stream.of(
                Arguments.of(WinTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7), 6),
                Arguments.of(WinTicket.of(Arrays.asList(11, 12, 13, 14, 15, 16), 17), 0),
                Arguments.of(WinTicket.of(Arrays.asList(1, 2, 13, 14, 15, 16), 17), 2)
        );
    }
}
