package string_add_calculator;

import org.junit.jupiter.api.Test;
import string_add_calculator.util.StringAddCalculatorUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorUtilTest {

    StringAddCalculatorUtil stringAddCalculatorUtil = new StringAddCalculatorUtil();

    @Test
    void 문자열_하나_유효성_체크() {
        assertThat(stringAddCalculatorUtil.isCharIntValue('a')).isFalse();
    }

    @Test
    void 음수_하나_유효성_체크() {
        assertThat(stringAddCalculatorUtil.isCharIntValue('-')).isFalse();
    }

    @Test
    void 숫자_하나_최소값_유효성_체크() {
        assertThat(stringAddCalculatorUtil.isCharIntValue('0')).isTrue();
    }

    @Test
    void 숫자_하나_최댓값_유효성_체크() {
        assertThat(stringAddCalculatorUtil.isCharIntValue('9')).isTrue();
    }

    @Test
    void 문자열_유효성_체크() {
        assertThatThrownBy(() -> stringAddCalculatorUtil.toInt("aa"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_유효성_체크() {
        assertThatThrownBy(() -> stringAddCalculatorUtil.toInt("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 음수_두자리_유효성_체크() {
        assertThatThrownBy(() -> stringAddCalculatorUtil.toInt("-10"))
                .isInstanceOf(RuntimeException.class);
    }
}
