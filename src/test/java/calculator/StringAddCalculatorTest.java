package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringAddCalculatorTest {
    @Test
    void splitAndSum() throws Exception {
        assertAll(
                () -> assertThat(0).isEqualTo(StringAddCalculator.splitAndSum("")),
                () -> assertThat(0).isEqualTo(StringAddCalculator.splitAndSum(null)),
                () -> assertThat(3).isEqualTo(StringAddCalculator.splitAndSum("3")),
                () -> assertThat(6).isEqualTo(StringAddCalculator.splitAndSum("2,4")),
                () -> assertThat(9).isEqualTo(StringAddCalculator.splitAndSum("1,3:5")),
                () -> assertThat(9).isEqualTo(StringAddCalculator.splitAndSum("//;\n1;3;5"))
        );
    }
}
