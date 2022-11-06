package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static domain.LottoWinning.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    @ParameterizedTest
    @MethodSource("arrangeWinningCondition")
    void 일치한_번호_개수에_따른_당첨(Lotto lotto, WinningNumber winningNumber, LottoWinning lottoWinning) {
        assertThat(lotto.findWinning(winningNumber)).isEqualTo(lottoWinning);
    }

    static Stream<Arguments> arrangeWinningCondition() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        return Stream.of(
            Arguments.arguments(
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 7), FIRST_PRIZE,
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), 7), SECOND_PRIZE,
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(1, 2, 3, 4, 7, 8), 7), THIRD_PRIZE,
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(1, 2, 3, 7, 8, 9), 7), FOURTH_PRIZE,
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(1, 2, 3, 7, 8, 9), 7), FIFTH_PRIZE,
                new Lotto((n, s) -> numbers), new WinningNumber(Arrays.asList(7, 8, 9, 10, 11, 12), 7), NONE));
    }
}
