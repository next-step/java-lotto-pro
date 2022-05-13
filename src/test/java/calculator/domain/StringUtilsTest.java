package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    @Test
    @DisplayName("문자열 배열을 숫자배열로 반환 테스트")
    void to_Integers() {
        String[] inputs = {"1", "9", "100"};
        assertThat(StringUtils.toPositiveNumbers(inputs)).containsExactly(1, 9, 100);
    }

    @Test
    @DisplayName("음수값 예외 테스트")
    void 음수_예외() {
        String[] inputs = {"-1", "9"};
        assertThatThrownBy(() -> StringUtils.toPositiveNumbers(inputs)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 값 예외 테스트")
    void 숫자가_아닌_값_예외() {
        String[] inputs = {"a", "9"};
        assertThatThrownBy(() -> StringUtils.toPositiveNumbers(inputs)).isInstanceOf(IllegalArgumentException.class);
    }
}