package study.lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3", "1,2", "1", "1,2,3,4", "1,2,3,4,5" })
    void 입력된_문자열이_로또_숫자_개수인_6개가_아니면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The numbers entered are invalid as lotto numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "1,2,3,4,5,-", "(,1,2,3,4,5" })
    void 변경할_수_없는_문자열이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] The given string contains characters that cannot be converted to numbers.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "0,1,2,3,4,5", "-1,2,3,4,5" })
    void 음수_또는_0이_포함되어_있으면_IllegalArgumentException_발생(String winningNumbers) {
        assertThatThrownBy(() -> {
            new WinningNumbers(winningNumbers);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
