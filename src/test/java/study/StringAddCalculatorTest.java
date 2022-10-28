package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    public void splitAndSum_null_or_blank() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_number_only() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void splitAndSum_comma_seperator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 구분자를 컴마(,)이외에 콜론(:)으로도 구분하여 숫자의 합을 계산할 수 있다.")
    public void splitAndSum_comma_or_colon_seperator() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 구분자를 컴마(,)이외에 콜론(:)으로도 구분하여 숫자의 합을 계산할 수 있다.")
    public void splitAndSum_custom_seperator() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

}
