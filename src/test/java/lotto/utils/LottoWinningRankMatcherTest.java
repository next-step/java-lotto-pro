package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import generator.TestNumberGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.LottoNumbers;
import lotto.enums.WinningRank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinningRankMatcherTest {

    private LottoNumbers lastWeekWinningNumbers;

    @BeforeEach
    void lastWeekWinningNumbersSetUp() {
        lastWeekWinningNumbers = LottoNumbers.generateBy(
            new TestNumberGenerator(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersProvider")
    @DisplayName("지난 주 당첨 번호와 생성된 로또 번호를 비교하여 당첨결과를 확인할 수 있다. (1등)")
    void match01(WinningRank expectWinningRank, List<Integer> lottoNumbers) {
        // given
        LottoNumbers generateLottoNumbers = LottoNumbers.generateBy(
            new TestNumberGenerator(lottoNumbers)
        );

        // when
        WinningRank winningRank = LottoWinningRankMatcher.match(lastWeekWinningNumbers,
            generateLottoNumbers);

        // then
        assertThat(winningRank).isEqualTo(expectWinningRank);
    }

    static Stream<Arguments> lottoNumbersProvider() {
        return Stream.of(
            arguments(WinningRank.WIN_1, Arrays.asList(1, 2, 3, 4, 5, 6)),
            arguments(WinningRank.WIN_2, Arrays.asList(1, 2, 3, 4, 5, 7)),
            arguments(WinningRank.WIN_3, Arrays.asList(1, 2, 3, 4, 7, 8)),
            arguments(WinningRank.WIN_4, Arrays.asList(1, 2, 3, 7, 8, 9)),
            arguments(WinningRank.NO_WIN, Arrays.asList(1, 2, 7, 8, 9, 10)),
            arguments(WinningRank.NO_WIN, Arrays.asList(1, 7, 8, 9, 10, 11)),
            arguments(WinningRank.NO_WIN,Arrays.asList(7, 8, 9, 10, 11, 12))
        );
    }
}