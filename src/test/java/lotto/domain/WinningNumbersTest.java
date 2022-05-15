package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨번호를 입력하는 기능에 대한 테스트")
class WinningNumbersTest {

    @DisplayName("당첨번호가 1-45 사이의 값에 \"숫자,숫자,숫자\" 의 형식이라면 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "31,10,2,5,44,45", "15,8,9,22,24,43"})
    void winning_number_success_test(String input) {
        WinningNumbers winningNumbers = new WinningNumbers(input);
        assertThat(winningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }
}
