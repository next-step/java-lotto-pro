package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step3.utils.TestNumberProvider;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UniqueNumbersTest {

    private static int winningStart;
    private static int winningEnd;
    private static UniqueNumbers winning;
    private static List<Number> duplicatedNumbers;

    @BeforeAll
    public static void init() {
        winningStart = 1;
        winningEnd = 6;
        winning = TestNumberProvider.rangeUniqueNumbers(winningStart,winningEnd);
        duplicatedNumbers = TestNumberProvider.numbers(1,1,1,1,1,1);
    }

    @Test
    @DisplayName("중복된 번호를 사용하여 UniqueNumbers 생성시 Exception 발생")
    public void testInputNumbersError() {
        assertThatThrownBy(() -> {
            UniqueNumbers.generate(duplicatedNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Duplicate numbers cannot input.");
    }

    @ParameterizedTest(name = "{displayName} - winning: [{0} - {1}], select: [{2} - {3}], countOfMatch: [{4}]")
    @MethodSource("numberProvider")
    @DisplayName("일치하는 번호 개수 확인")
    public void testMatch(int winningStart, int winningEnd, int start, int end, int expected) {
        List<Number> numbers = TestNumberProvider.rangeNumbers(start, end);
        UniqueNumbers select = UniqueNumbers.generate(numbers);
        assertThat(winning.match(select)).isEqualTo(expected);
    }

    private static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(winningStart, winningEnd, 7, 12, 0),
                Arguments.of(winningStart, winningEnd, 6, 11, 1),
                Arguments.of(winningStart, winningEnd, 5, 10, 2),
                Arguments.of(winningStart, winningEnd, 4, 9, 3),
                Arguments.of(winningStart, winningEnd, 3, 8, 4),
                Arguments.of(winningStart, winningEnd, 2, 7, 5),
                Arguments.of(winningStart, winningEnd, 1, 6, 6)
        );
    }

    private static List<Number> generateLottoNumbers(List<Integer> selectNumbers) {
        return selectNumbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }
}
