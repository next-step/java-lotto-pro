package lotto.domain.winningnumber.bonus.validation;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

class NumberValidatorTest {

    BonusValidator validator = new NumberValidator();

    @ParameterizedTest
    @DisplayName("공백이면 EX 발생")
    @EmptySource
    void empty(String ex) {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @DisplayName("숫자라면 통과 아니면 EX 발생")
    @CsvSource(value = {"1:a", "10:B", "100:!"}, delimiter = ':')
    void numberValidate(String success, String ex) {
        assertThatNoException().isThrownBy(() -> validator.validate(success));
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validate(ex))
                .withMessageContaining("[ERROR]");
    }
}
