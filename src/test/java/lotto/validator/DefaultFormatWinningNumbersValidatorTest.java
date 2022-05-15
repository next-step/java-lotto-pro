package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import lotto.validator.impl.DefaultFormatWinningNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("당첨번호의 기본 포맷에 대한 테스트")
class DefaultFormatWinningNumbersValidatorTest {

    @DisplayName("당첨번호가 \"숫자,숫자,숫자\" 형식이 아니라면 예외를 발생시켜야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1:3:5:6:7:11", "3,6,11,12,15,43,", "a,3,5,32,11,bb"})
    void default_format_test(String input) {
        WinningNumbersValidator validator = new DefaultFormatWinningNumbersValidator();
        assertThatThrownBy(() -> {
            validator.validate(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.INVALID_WINNING_NUMBER_FORMAT.getMessage());
    }
}
