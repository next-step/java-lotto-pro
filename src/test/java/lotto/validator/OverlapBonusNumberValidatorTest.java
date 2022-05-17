package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import lotto.domain.validator.NumberValidator;
import lotto.domain.validator.impl.OverlapBonusNumberValidator;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("보너스번호의 중복 테스트")
class OverlapBonusNumberValidatorTest {

    @DisplayName("보너스번호가 앞선 당첨번호와 중복되면 예외가 발생해야 한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:6", "21,44,3,14,1,6:44", "31,45,13,3,5,19:31", "2,4,12,43,33,22:22"}, delimiter = ':')
    void overlap_bonus_number_test(String 당첨_번호, String 보너스_번호) {
        int[] 당첨_번호_array = convertStringArrayToIntArray(당첨_번호.split(","));

        NumberValidator numberValidator = new OverlapBonusNumberValidator();
        assertThatThrownBy(() -> {
            numberValidator.validate(보너스_번호, 당첨_번호_array);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.ALREADY_EXISTS_WINNINGS_NUMBER.getMessage());
    }

    private int[] convertStringArrayToIntArray(String[] stringArray) {
        return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
    }
}
