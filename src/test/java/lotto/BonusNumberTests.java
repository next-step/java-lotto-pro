package lotto;

import lotto.exception.InvalidInputException;
import lotto.model.BonusNumber;
import lotto.model.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("보너스번호 기능 테스트")
public class BonusNumberTests {

    private static final String INVALID_WINNING_NUMBER_MESSAGE = "1-45 사이의 숫자만 입력할 수 있습니다.";
    private static final String INVALID_DUPLICATE_MESSAGE = "당첨번호와 중복된 보너스번호를 입력할 수 없습니다.";

    @DisplayName("보너스번호 생성 성공을 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;7", "8,10,24,38,44,45;12"}, delimiterString = ";")
    public void 보너스번호_생성_성공(String inputValues, String inputBonusNumber) {
        LottoNumbers winningNumbers = new LottoNumbers(inputValues);
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber, winningNumbers);

        assertThat(bonusNumber.getValue())
                .isInstanceOf(Integer.class)
                .isNotNull()
                .isEqualTo(Integer.valueOf(inputBonusNumber));
    }

    @DisplayName("보너스번호 생성시, 범위 이탈 검출을 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;0"}, delimiterString = ";")
    public void 보너스번호_생성_범위이탈검출(String inputValues, String inputBonusNumber) {
        LottoNumbers winningNumbers = new LottoNumbers(inputValues);

        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(INVALID_WINNING_NUMBER_MESSAGE);
    }

    @DisplayName("보너스번호 생성 중복검출을 테스트합니다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6;1"}, delimiterString = ";")
    public void 보너스번호_생성_중복검출(String inputValues, String inputBonusNumber) {
        LottoNumbers winningNumbers = new LottoNumbers(inputValues);
        assertThatThrownBy(() -> new BonusNumber(inputBonusNumber, winningNumbers))
                .isInstanceOf(InvalidInputException.class)
                .hasMessageContaining(INVALID_DUPLICATE_MESSAGE);
    }

}
