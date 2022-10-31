package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constant.LottoConstant;
import lotto.domain.TestLottoNumberGenerator;
import lotto.domain.win.WinRanking;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    private final List<LottoNumber> winningNumbers =
            TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate();
    private final LottoNumber bonusNumber = LottoNumber.from(7);

    private static Stream<Arguments> winningCount() {
        return Stream.of(
                Arguments.of(WinRanking.FIRST, 1),
                Arguments.of(WinRanking.SECOND, 1),
                Arguments.of(WinRanking.THIRD, 1),
                Arguments.of(WinRanking.FOURTH, 1),
                Arguments.of(WinRanking.FIFTH, 0),
                Arguments.of(WinRanking.MISS, 2)
        );
    }

    @Test
    @DisplayName("당첨번호에 보너스 번호가 포함되면 IllegalArgumentException을 던진다.")
    void winningLottoException() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Assertions.assertThatThrownBy(() -> WinningLotto.of(winningNumbers, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{index} | {displayName} | 당첨등수 = {0}, 당첨된 로또 갯수 = {1}")
    @MethodSource(value = "winningCount")
    @DisplayName("당첨등수 별 당첨된 로또 갯수 확인")
    void winResults(WinRanking input, int expected) {
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

        Map<WinRanking, Integer> winningCountByWinRanking = winningLotto.winResults(getTestLottos());

        Assertions.assertThat(winningCountByWinRanking.getOrDefault(input, LottoConstant.EMPTY_WINNING_COUNT))
                .isEqualTo(expected);
    }

    private Lottos getTestLottos() {
        Lotto lotto1 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        Lotto lotto2 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 7)).generate());
        Lotto lotto3 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 8)).generate());
        Lotto lotto4 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 7, 8)).generate());
        Lotto lotto5 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 10, 7, 8, 9)).generate());
        Lotto lotto6 = Lotto.from(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 10, 7, 8, 9)).generate());

        return Lottos.from(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6));
    }
}
