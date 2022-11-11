package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberTest {
    @ParameterizedTest
    @MethodSource("arrangeCountOfMatchCondition")
    void 보너스번호를_제외한_당첨된_번호_개수(Set<Integer> numbers, WinningNumber winningNumber, int countOfMatch) {
        assertThat(winningNumber.countOfMatch(numbers)).isEqualTo(countOfMatch);
    }

    @ParameterizedTest
    @MethodSource("arrangeBonusNumberCondition")
    void 보너스번호_당첨(Set<Integer> numbers, WinningNumber winningNumber, boolean isBonusNumberMatched) {
        assertThat(winningNumber.isBonusNumberMatched(numbers)).isEqualTo(isBonusNumberMatched);
    }

    static Stream<Arguments> arrangeCountOfMatchCondition() {
        BonusWinningNumber bonusWinningNumber = new BonusWinningNumber(6);
        return Stream.of(
                Arguments.arguments(
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 12, 13, 14, 15, 16), bonusWinningNumber), 1,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 13, 14, 15, 16), bonusWinningNumber), 2,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 14, 15, 16), bonusWinningNumber), 3,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 4, 15, 16), bonusWinningNumber), 4,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 16), bonusWinningNumber), 5,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), bonusWinningNumber), 6));
    }

    static Stream<Arguments> arrangeBonusNumberCondition() {
        return Stream.of(
                Arguments.arguments(
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 7), new BonusWinningNumber(6)), true,
                        new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), new BonusWinningNumber(7)), false));
    }
}
