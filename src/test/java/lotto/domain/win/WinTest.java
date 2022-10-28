package lotto.domain.win;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.TestLottoNumberGeneratorStrategy;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinTest {

    private final List<LottoNumber> numbers =
            TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate();

    private static Stream<Arguments> winningNumbersWithMatchCount() {
        return Stream.of(
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate(), 6),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 3, 4, 5, 7)).generate(), 5),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 3, 4, 7, 8)).generate(), 4),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 3, 7, 8, 9)).generate(), 3),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 2, 7, 8, 9, 10)).generate(), 2),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(1, 7, 8, 9, 10, 11)).generate(), 1),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(Arrays.asList(7, 8, 9, 10, 11, 12)).generate(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "winningNumbersWithMatchCount")
    @DisplayName("로또번호(로또 1장)와 입력된 당첨번호를 전체 비교하여 일치하는 번호의 갯수를 확인한다.")
    void lottoNumbersMatches2(List<LottoNumber> input, int expected) {
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        LottoNumbers winningNumbers = LottoNumbers.from(input);

        int result = lottoNumbers.matches(winningNumbers);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
