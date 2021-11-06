package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoResultsTest {
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        6
                ),Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 7, 8, 9),
                        3
                ),Arguments.of(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(7, 8, 9, 10, 11, 12),
                        0
                )
        );
    }

    @DisplayName("당첨 번호와 일치하는 갯수 테스트")
    @ParameterizedTest
    @MethodSource("args")
    void matchedNumberTest(List<Integer> lotto, List<Integer> winningLotto, int expected) {
        LottoResults results = new LottoResults();
        Assertions.assertThat(results.getMatchedCount(lotto, winningLotto)).isEqualTo(expected);
    }
}
