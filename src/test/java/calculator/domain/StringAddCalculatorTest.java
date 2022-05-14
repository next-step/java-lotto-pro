package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;


public class StringAddCalculatorTest {
    @Test
    void 널_또는_빈문자() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0)
        );
    }

    @Test
    void 숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수_예외() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자_아닌_값_예외() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
