package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.TestLottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    private final List<LottoNumber> numbers =
            TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate();

    private static Stream<Arguments> winningNumbersWithMatchCount() {
        return Stream.of(
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate(), 6),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 7)).generate(), 5),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 7, 8)).generate(), 4),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 7, 8, 9)).generate(), 3),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 7, 8, 9, 10)).generate(), 2),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 7, 8, 9, 10, 11)).generate(), 1),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(7, 8, 9, 10, 11, 12)).generate(), 0)
        );
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7)).generate()),
                Arguments.of(TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5)).generate())
        );
    }

    @ParameterizedTest
    @MethodSource(value = "winningNumbersWithMatchCount")
    @DisplayName("로또번호(로또 1장)와 입력된 당첨번호를 전체 비교하여 일치하는 번호의 갯수를 확인한다.")
    void lottoNumbersMatches1(List<LottoNumber> input, int expected) {
        Lotto lotto = Lotto.from(numbers);

        int result = lotto.matches(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("중복된 로또번호가 있으면 IllegalArgumentException을 던진다.")
    void lottoException1() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.from(1), LottoNumber.from(1),
                LottoNumber.from(2), LottoNumber.from(3),
                LottoNumber.from(4), LottoNumber.from(5)
        );

        Assertions.assertThatThrownBy(() -> Lotto.from(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource(value = "lottoNumbers")
    @DisplayName("로또번호가 6개가 아니면 IllegalArgumentException을 던진다.")
    void lottoException2(List<LottoNumber> input) {
        Assertions.assertThatThrownBy(() -> Lotto.from(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
