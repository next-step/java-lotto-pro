package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CustomedTextTest {

    @Test
    @DisplayName("허용되지 않은 구분자를 사용하는지 테스트한다")
    void validate테스트() {
        assertThatThrownBy(() -> new CustomedText("1;2!3;4", ";"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining(StringAddCalculator.INVALID_CUSTOM_PATTERN_ERR_MSG);
    }

    @Test
    @DisplayName("정규식이 맞는지 확인하는 용도의 테스트")
    void match테스트() {
        assertThat("-1".matches("-.")).isTrue();
        String delimeter = ";";
        assertThat("1;2!3;4".matches(".*\\d[^"+delimeter+"]\\d.*")).isTrue();
    }

}