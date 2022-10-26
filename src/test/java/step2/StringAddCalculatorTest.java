package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {


    @Test
    @DisplayName("splitAndSum메소드는 null값을 입력하면 0을 리턴")
    public void returns_0_if_null_value_input() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("splitAndSum메소드는 빈값을 입력하면 0을 리턴")
    public void returns_0_if_empty_value_input() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }
}
