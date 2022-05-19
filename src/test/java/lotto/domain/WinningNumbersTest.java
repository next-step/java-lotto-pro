package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("당첨번호가 1-45 사이의 값에 \"숫자, 숫자, 숫자\" 의 공백이 추가된 형식이라도 정상적으로 통과되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "31, 10, 2, 5, 44, 45", "15, 8, 9, 22, 24, 43"})
    void winning_number_success_test2(String input) {
        WinningNumbers winningNumbers = new WinningNumbers(input);
        assertThat(winningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }

    @DisplayName("보너스 번호가 존재하면 1을 반환받고 아니라면 0을 반환해야 한다")
    @Test
    void bonus_count_test() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        winningNumbers.addBonusNumber(new BonusNumber("7"));

        Lotto 보너스번호_있는_로또 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto 보너스번호_없는_로또 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        assertThat(winningNumbers.bonusCount(보너스번호_있는_로또)).isEqualTo(1);
        assertThat(winningNumbers.bonusCount(보너스번호_없는_로또)).isEqualTo(0);
    }

    @DisplayName("보너스 번호가 존재하면 true 를 반환받고 아니라면 false 를 반환해야 한다")
    @Test
    void is_contains_test() {
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        winningNumbers.addBonusNumber(new BonusNumber("7"));

        Lotto 보너스번호_있는_로또 = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));
        Lotto 보너스번호_없는_로또 = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15));

        assertTrue(winningNumbers.isContainsBonusNumber(보너스번호_있는_로또));
        assertFalse(winningNumbers.isContainsBonusNumber(보너스번호_없는_로또));
    }
}
