import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "{arguments}은 0을 반환")
    @NullAndEmptySource
    void null_또는_빈문자(String value) {
        assertThat(StringAddCalculator.splitAndSum(value)).isEqualTo(0);
    }
}
