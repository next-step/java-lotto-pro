package lotto.util;

import static lotto.util.LottoInputValidator.validateBonusNumber;
import static lotto.util.LottoInputValidator.validatePurchasePrice;
import static lotto.util.LottoInputValidator.validateLottoNumbers;
import static lotto.util.LottoInputValidator.validateManualLottoCount;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputValidatorTest {

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"a, -1, #"})
    @DisplayName("구매가격에 0 이상의 숫자가 입력되지 않는 경우 false를 반환한다.")
    void validatePurchasePrice1(String input) {
        assertThat(validatePurchasePrice(input)).isFalse();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"0", "10", "500", "999"})
    @DisplayName("구매가격이 로또 한 장(1000원) 가격이 아니면 false를 반환한다.")
    void validatePurchasePrice2(String input) {
        assertThat(validatePurchasePrice(input)).isFalse();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"1000", "1001", "3000"})
    @DisplayName("구매가격이 로또 한 장(1000원) 가격 이상이면 true를 반환한다.")
    void validatePurchasePrice3(String input) {
        assertThat(validatePurchasePrice(input)).isTrue();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"-1", "0", "46", "abc", "1,2,3,4,5,-1"})
    @DisplayName("당첨번호가 1 ~ 45 사이의 값이 아니면 false를 반환한다.")
    void validateWinningNumbers1(String input) {
        assertThat(validateLottoNumbers(input)).isFalse();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"1,2,3,1,4,5", "1,2,3,4,5", "1,2,3,4,5,5,6"})
    @DisplayName("당첨번호가 6개의 중복되지 않은 숫자가 아니면 false를 반환한다.")
    void validateWinningNumbers2(String input) {
        assertThat(validateLottoNumbers(input)).isFalse();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}")
    @ValueSource(strings = {"1,2,3,4,5,6", "1,12,21,33,44,45"})
    @DisplayName("당첨번호가 1 ~ 45 숫자 이내의 중복되지 않는 6개 숫자이면 true를 반환한다.")
    void validateWinningNumbers3(String input) {
        assertThat(validateLottoNumbers(input)).isTrue();
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}, output = {1}")
    @CsvSource(
            value = {"-1:false", "0:false", "46:false", "abc:false", "1:true", "10:true", "45:true"},
            delimiter = ':'
    )
    @DisplayName("보너스 번호가 1 ~ 45 사이에 포함되면 true, 포함안되면 false를 반환한다.")
    void validateBonusNumber1(String input, boolean expected) {
        List<Integer> winningNumbers = Arrays.asList(3, 6, 9, 12, 15, 18);
        assertThat(validateBonusNumber(input, winningNumbers)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} | {displayName} | input = {0}, output = {1}")
    @CsvSource(value = {"1:false", "7:true"}, delimiter = ':')
    @DisplayName("보너스 번호가 당첨번호에 포함되면 false, 포함안되면 true을 반환한다.")
    void validateBonusNumber2(String input, boolean expected) {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(validateBonusNumber(input, winningNumbers)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{index} | {displayName} | 전체 : 10, 수동 : {0}, 결과 : {1}")
    @CsvSource(value = {"0:true", "1:true", "5:true", "10:true", "11:false"}, delimiter = ':')
    @DisplayName("수동으로 구입할 로또 수가 전체 구입할 수 이하이면 true, 초과면 false를 반환한다.")
    void validateManualLottoCounts(String input, boolean expected) {
        assertThat(validateManualLottoCount(10, input)).isEqualTo(expected);
    }
}