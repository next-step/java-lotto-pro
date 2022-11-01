package domain;

import static domain.LottoWinning.FIRST_PRIZE;
import static domain.LottoWinning.FOURTH_PRIZE;
import static domain.LottoWinning.NONE;
import static domain.LottoWinning.SECOND_PRIZE;
import static domain.LottoWinning.THIRD_PRIZE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {
    @ParameterizedTest
    @MethodSource("arrangeWinningCondition")
    void 일치한_번호_개수에_따른_당첨(Lotto lotto, List<Integer> winningNumbers, LottoWinning lottoWinning) {
        assertThat(lotto.findWinning(winningNumbers)).isEqualTo(lottoWinning);
    }

    static Stream<Arguments> arrangeWinningCondition() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        return Stream.of(
            Arguments.arguments(
                new Lotto((n, s) -> numbers), Arrays.asList(1, 2, 3, 4, 5, 6), FIRST_PRIZE,
                new Lotto((n, s) -> numbers), Arrays.asList(1, 2, 3, 4, 5, 7), SECOND_PRIZE,
                new Lotto((n, s) -> numbers), Arrays.asList(1, 2, 3, 4, 7, 8), THIRD_PRIZE,
                new Lotto((n, s) -> numbers), Arrays.asList(1, 2, 3, 7, 8, 9), FOURTH_PRIZE,
                new Lotto((n, s) -> numbers), Arrays.asList(7, 8, 9, 10, 11, 12), NONE));
    }
}
