package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.constant.ErrorCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositiveNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "1.2", "abc"})
    void 주어진_문자열_숫자가_정수가_아니면_에러_발생(String textNumber) {
        assertThatThrownBy(() -> new PositiveNumber(textNumber)).isInstanceOf(NumberFormatException.class).hasMessage(
                ErrorCode.정수값이_아님.getErrorMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-40"})
    void 주어진_문자열_숫자가_음수이면_에러_발생(String textNumber) {
        assertThatThrownBy(() -> new PositiveNumber(textNumber)).isInstanceOf(IllegalArgumentException.class).hasMessage(
                ErrorCode.음의_정수가_입력되면_안됨.getErrorMessage());
    }
}
