package lotto.domain;

import lotto.exception.DuplicateWinningNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningTest {

    private static Stream<Arguments> inputWinningTest() {
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", new Integer[]{1, 2, 3, 4, 5, 6}),
                Arguments.of("45,44,43,42,41,40", new Integer[]{40, 41, 42, 43, 44, 45})
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨 번호 입력(순서 정렬)")
    public void inputWinningTest(String input, Integer[] result) {
        LottoNumbers winningNumbers = LottoNumbers.fromString(input);
        assertThat(Winning.of(winningNumbers, 30)).isInstanceOf(Winning.class);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6|1",
    }, delimiter = '|')
    @DisplayName("보너스 번호는 당첨번호와 중복 될 수 없다.")
    public void duplicateLottoNumberByBonusNumber(String input, int bonusNumber) {
        LottoNumbers winningNumbers = LottoNumbers.fromString(input);
        assertThatThrownBy(() -> Winning.of(winningNumbers, bonusNumber)).isInstanceOf(DuplicateWinningNumberException.class);
    }

}