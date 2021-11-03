import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "{arguments}은 0을 반환")
    @NullAndEmptySource
    void null_또는_빈문자(String value) {
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }

    @Test
    void 숫자_하나() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 쉼표_구분자_또는_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수인_경우_RuntimeException() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"));
    }
}
