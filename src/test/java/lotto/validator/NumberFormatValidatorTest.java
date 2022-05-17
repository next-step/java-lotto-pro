package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.validator.NumberValidator;
import lotto.domain.validator.impl.NumberFormatValidator;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또번호의 숫자포맷에 대한 테스트")
class NumberFormatValidatorTest {

    @DisplayName("로또번호가 숫자 이외의 값을 전달받으면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"aa", "@#$", "q", "woo"})
    void lotto_number_format_test(String given) {

        NumberValidator numberValidator = new NumberFormatValidator();
        assertThatThrownBy(() -> {
            numberValidator.validate(given);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_NUMBER_FORMAT.getMessage());
    }
}
