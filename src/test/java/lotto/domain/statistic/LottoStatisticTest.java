package lotto.domain.statistic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.TestLottoNumberGenerator;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.win.WinRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoStatisticTest {

    private final List<LottoNumber> winningNumbers =
            TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate();

    private static Stream<Arguments> winningCount() {
        return Stream.of(
                Arguments.of(WinRanking.FIRST, 0),
                Arguments.of(WinRanking.SECOND, 0),
                Arguments.of(WinRanking.THIRD, 2),
                Arguments.of(WinRanking.FOURTH, 1)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "winningCount")
    @DisplayName("당첨된 로또 갯수 확인")
    void winningLottoCount(WinRanking input, int expected) {
        LottoStatistic lottoStatistic = LottoStatistic.of(getTestLottos(), winningNumbers);
        LottoStatisticResults lottoStatisticResults = lottoStatistic.results();

        int result = lottoStatisticResults.winningCount(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률 확인")
    void profit() {
        LottoStatistic lottoStatistic = LottoStatistic.of(getTestLottos(), winningNumbers);

        double result = lottoStatistic.profit();

        Assertions.assertThat(result).isEqualTo(21.0);
    }

    private Lottos getTestLottos() {
        Lotto lotto1 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(8, 21, 23, 41, 42, 43)).generate());
        Lotto lotto2 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(7, 11, 16, 35, 36, 44)).generate());
        Lotto lotto3 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 30, 7)).generate());
        Lotto lotto4 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 15, 3, 4, 6, 8)).generate());
        Lotto lotto5 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 7, 8, 9)).generate());

        return Lottos.from(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));
    }
}
