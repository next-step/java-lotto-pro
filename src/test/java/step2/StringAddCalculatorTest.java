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
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    public void returns_sum_if_two_number_entered_with_comma_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,)또는콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

}
