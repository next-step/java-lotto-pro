package calculator.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationUtilsTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자 입력시 true 리턴되는지 확인")
    public void isNullOrEmpty_null_또는_빈문자(String input) {
        boolean result = ValidationUtils.isNullOrEmpty(input);
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "%"})
    @DisplayName("음수 또는 숫자 이외의 값 입력 시 Exception 발생 확인")
    public void validateNumber_negative(String input) throws Exception {
        assertThatThrownBy(() -> ValidationUtils.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
