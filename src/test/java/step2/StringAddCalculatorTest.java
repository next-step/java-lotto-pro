package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }
    @Test
    public void splitAndSum_문자하나_에러발생() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}