package lotto.domain.winning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BonusNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("보너스 번호가 1 ~ 45 사이의 값이 아닐 경우 예외가 발생한다.")
    void validateRange(int invalidBonusNumber) {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(winningNumbers, invalidBonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 중복될 경우 예외가 발생한다.")
    void validateDuplication() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        int invalidBonusNumber = 5;

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new BonusNumber(winningNumbers, invalidBonusNumber));
    }
}