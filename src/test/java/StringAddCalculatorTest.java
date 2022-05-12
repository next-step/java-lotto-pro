import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다.")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);

        result = StringAddCalculator.splitAndSum("5");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
        System.out.println();
    }

    @Test
    @DisplayName("컴마 이외에 콜론 구분자로 입력할 경우 숫자의 합을 제대로 반환하는지 확인")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자 사용시 숫자의 합을 제대로 반환하는지 확인")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수 입력시 RuntimeException 예외 발생시키는지 확인")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수 하나로 구성된 문자열일 경우 RuntimeException 예외 발생시키는지 확인")
    public void splitAndSum_negative_숫자하나() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @DisplayName("숫자가 아닌 값이 문자열에 포함될 경우 RuntimeException 예외 발생시키는지 확인")
    @ValueSource(strings = {"1,2,a","1::2",":1"})
    void splitAndSum_notNumber(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}