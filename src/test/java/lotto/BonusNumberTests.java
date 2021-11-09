package lotto;

import lotto.exception.InvalidInputException;
import lotto.model.BonusNumber;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("보너스번호 기능 테스트")
public class BonusNumberTests {

    @DisplayName("보너스번호 생성 성공을 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;7", "8,10,24,38,44,45;12"}, delimiterString = ";")
    public void 보너스번호_생성_성공(String inputValues, String inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputValues);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);

        assertThat(bonusNumber.getValue())
                .isInstanceOf(Integer.class)
                .isNotNull()
                .isEqualTo(Integer.valueOf(inputBonusNumber));
    }

    @DisplayName("보너스번호 생성 실패를 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;0", "1,2,3,4,5,6;1"}, delimiterString = ";")
    public void 보너스번호_생성_실패(String inputValues, String inputBonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputValues);

        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers)).isInstanceOf(InvalidInputException.class);
    }

}
