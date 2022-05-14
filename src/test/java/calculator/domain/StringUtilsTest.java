package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringUtilsTest {
    @Test
    @DisplayName("문자열 배열을 숫자배열로 반환 테스트")
    void to_PositiveNumbers() {
        String[] inputs = {"1", "9", "100"};
        assertThat(StringUtils.toPositiveNumbers(inputs))
                .containsExactly(
                        PositiveNumber.of("1"),
                        PositiveNumber.of("9"),
                        PositiveNumber.of("100")
                );
    }
}