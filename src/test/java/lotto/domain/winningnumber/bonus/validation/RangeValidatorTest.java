package lotto.domain.winningnumber.bonus.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RangeValidatorTest {

    BonusValidator validator = new RangeValidator();

    @ParameterizedTest
    @DisplayName("보너스볼이 1~45 사이의 숫자가 아니면 EX 발생")
    @CsvSource(value = {"1:46", "20:0", "45:123"}, delimiter = ':')
    void rangeValidate(String success, String ex) {
        assertThatNoException().isThrownBy(() -> validator.validate(success));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining("[ERROR]");
    }
}
