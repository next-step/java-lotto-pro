package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {


    @Test
    @DisplayName("null값을 입력하면 0을 반환")
    public void returns_0_if_null_value_input() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈값을 입력하면 0을 반환")
    public void returns_0_if_empty_value_input() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자를 컴마(,) 구분자로 입력할 경우 숫자의 합을 반환")
    public void returns_sum_if_number_entered_with_comma() {
        int result = StringAddCalculator.splitAndSum("1,2,3,4,5");
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("숫자를 컴마(,)또는콜론(:) 구분자로 입력할 경우 숫자의 합을 반환")
    public void returns_sum_if_number_entered_with_comma_or_delimiter() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3:7");
        assertThat(result).isEqualTo(13);
    }

}
