package lotto.util;

import java.util.Arrays;
import lotto.domain.TestLottoNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoInputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"a, -1, #"})
    @DisplayName("구매가격에 0 이상의 숫자가 입력되지 않는 경우 false를 반환한다.")
    void validatePurchasePrice1(String input) {
        Assertions.assertThat(LottoInputValidator.validatePurchasePrice(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "500", "999"})
    @DisplayName("구매가격이 로또 한 장(1000원) 가격이 아니면 false를 반환한다.")
    void validatePurchasePrice2(String input) {
        Assertions.assertThat(LottoInputValidator.validatePurchasePrice(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "1001", "3000"})
    @DisplayName("구매가격이 로또 한 장(1000원) 가격 이상이면 true를 반환한다.")
    void validatePurchasePrice3(String input) {
        Assertions.assertThat(LottoInputValidator.validatePurchasePrice(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "46", "abc", "1,2,3,4,5,-1"})
    @DisplayName("당첨번호가 1 ~ 45 사이의 값이 아니면 false를 반환한다.")
    void validateWinningNumbers1(String input) {
        Assertions.assertThat(LottoInputValidator.validateWinningNumbers(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,1,4,5", "1,2,3,4,5", "1,2,3,4,5,5,6"})
    @DisplayName("당첨번호가 6개의 중복되지 않은 숫자가 아니면 false를 반환한다.")
    void validateWinningNumbers2(String input) {
        Assertions.assertThat(LottoInputValidator.validateWinningNumbers(input)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1,12,21,33,44,45"})
    @DisplayName("당첨번호가 1 ~ 45 숫자 이내의 중복되지 않는 6개 숫자이면 true를 반환한다.")
    void validateWinningNumbers3(String input) {
        Assertions.assertThat(LottoInputValidator.validateWinningNumbers(input)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            value = {"-1:false", "0:false", "46:false", "abc:false", "1:true", "10:true", "45:true"},
            delimiter = ':'
    )
    @DisplayName("보너스 번호가 1 ~ 45 사이에 포함되면 true, 포함안되면 false를 반환한다.")
    void validateBonusNumber1(String input, boolean expected) {
        Assertions.assertThat(
                LottoInputValidator.validateBonusNumber(
                        input, TestLottoNumberGenerator.from(Arrays.asList(3, 6, 9, 12, 15, 18)).generate()
                )
        ).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:false", "7:true"}, delimiter = ':')
    @DisplayName("보너스 번호가 당첨번호에 포함되면 false, 포함안되면 true을 반환한다.")
    void validateBonusNumber2(String input, boolean expected) {
        Assertions.assertThat(
                LottoInputValidator.validateBonusNumber(
                        input, TestLottoNumberGenerator.from(Arrays.asList(1, 2, 3, 4, 5, 6)).generate()
                )
        ).isEqualTo(expected);
    }
}