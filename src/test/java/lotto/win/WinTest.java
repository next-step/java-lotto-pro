package lotto.win;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.Lotto;
import lotto.LottoNumber;
import lotto.LottoNumbers;
import lotto.TestLottoNumberGeneratorStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
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

    private static Stream<Arguments> winningNumbersWithWin() {
        return Stream.of(
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 2, 3, 4, 5, 6)).generate(), true),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 2, 3, 4, 5, 7)).generate(), true),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 2, 3, 4, 7, 8)).generate(), true),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 2, 3, 7, 8, 9)).generate(), true),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 2, 7, 8, 9, 10)).generate(), false),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(1, 7, 8, 9, 10, 11)).generate(), false),
                Arguments.of(TestLottoNumberGeneratorStrategy.from(
                        Arrays.asList(7, 8, 9, 10, 11, 12)).generate(), false)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "7:false", "8:false", "9:false", "10:false"}, delimiter = ':')
    @DisplayName("로또번호(로또 1장)와 당첨번호 1개 비교 테스트")
    void lottoNumbersMatches1(int input, boolean expected) {
        LottoNumbers lottoNumbers = LottoNumbers.from(numbers);
        boolean result = lottoNumbers.matches(LottoNumber.from(input));
        Assertions.assertThat(result).isEqualTo(expected);
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

    @ParameterizedTest
    @MethodSource(value = "winningNumbersWithWin")
    @DisplayName("로또가 당첨되었는지 확인")
    void lottoWin(List<LottoNumber> input, boolean expected) {
        Lotto lotto = Lotto.from(LottoNumbers.from(numbers), new DefaultWinPolicy());
        LottoNumbers winningNumbers = LottoNumbers.from(input);

        boolean result = lotto.isWin(winningNumbers);

        Assertions.assertThat(result).isEqualTo(expected);
    }
}
