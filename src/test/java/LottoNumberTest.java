import model.LottoNumber;
import model.strategy.MockStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("sortNumberTest")
    void 로또번호는_오름차순이여야한다(List<Integer> input, List<Integer> expect) {
        LottoNumber lottoNumber = new LottoNumber(new MockStrategy(input));

        assertThat(lottoNumber.toString()).isEqualTo(expect.toString());
    }

    public static Stream<Arguments> sortNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 6, 3, 5, 2, 4), Arrays.asList(1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(45, 23, 30, 12, 1, 9), Arrays.asList(1, 9, 12, 23, 30, 45))
        );
    }

    @ParameterizedTest
    @MethodSource("winNumberTest")
    void 당첨번호와_일치하는_로또번호의_갯수를_구한다(List<Integer> input, List<Integer> winNumber, int expect) {
        LottoNumber lottoNumber = new LottoNumber(new MockStrategy(input));
        int winNumberCount = lottoNumber.getWinNumberCount(winNumber);
        assertEquals(winNumberCount, expect);
    }

    public static Stream<Arguments> winNumberTest() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(1, 2, 3, 4, 9, 10), 4),
                Arguments.of(Arrays.asList(1, 9, 12, 23, 30, 45), Arrays.asList(2, 3, 4, 5, 6, 7), 0),
                Arguments.of(Arrays.asList(1, 9, 12, 23, 30, 45), Arrays.asList(1, 9, 12, 23, 30, 45), 6)
        );
    }
}
