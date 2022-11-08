package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BonusWinningNumberTest {
    @ParameterizedTest
    @MethodSource("arrangeBonusWinningNumber")
    void 보너스볼_포함여부(BonusWinningNumber bonusWinningNumber, Set<Integer> numbers, boolean expected) {
        assertThat(bonusWinningNumber.in(numbers)).isEqualTo(expected);
    }

    static Stream<Arguments> arrangeBonusWinningNumber() {
        return Stream.of(
                Arguments.arguments(
                        new BonusWinningNumber(1), new HashSet<>(Arrays.asList(1,2,3,4,5,6)), true,
                        new BonusWinningNumber(7), new HashSet<>(Arrays.asList(1,2,3,4,5,6)), false));
    }
}