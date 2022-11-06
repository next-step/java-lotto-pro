package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static domain.LottoWinning.*;
import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    @ParameterizedTest
    @MethodSource("arrangeLottoWinningCondition")
    void 가격_테스트(List<LottoWinning> lottoWinnings, int firstPrizeCount, int secondPrizeCount,
                int thirdPrizeCount, int fourthPrizeCount, int fifthPrizeCount, int nonePrizeCount, int totalPrize) {
        WinningResult winningResult = new WinningResult();
        lottoWinnings.forEach(winningResult::increment);
        assertThat(winningResult.countOfMatch(FIRST_PRIZE)).isEqualTo(firstPrizeCount);
        assertThat(winningResult.countOfMatch(SECOND_PRIZE)).isEqualTo(secondPrizeCount);
        assertThat(winningResult.countOfMatch(THIRD_PRIZE)).isEqualTo(thirdPrizeCount);
        assertThat(winningResult.countOfMatch(FOURTH_PRIZE)).isEqualTo(fourthPrizeCount);
        assertThat(winningResult.countOfMatch(FIFTH_PRIZE)).isEqualTo(fifthPrizeCount);
        assertThat(winningResult.countOfMatch(NONE)).isEqualTo(nonePrizeCount);
        assertThat(winningResult.totalPrize()).isEqualTo(totalPrize);
    }

    static Stream<Arguments> arrangeLottoWinningCondition() {
        return Stream.of(
            Arguments.arguments(
                Arrays.asList(NONE, NONE), 0, 0, 0, 0, 0, 2, 0,
                Arrays.asList(FOURTH_PRIZE, FIFTH_PRIZE), 0, 0, 0, 0, 0, 0, 55000,
                Arrays.asList(FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FOURTH_PRIZE, FIFTH_PRIZE, NONE), 1, 1, 1, 1, 1, 1, 2031605000));
    }
}
