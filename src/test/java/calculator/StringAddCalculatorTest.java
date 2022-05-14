package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈문자가 입력되는 경우 0을 반환하는지 확인한다.")
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력하면 같은 값을 반환하는지 확인한다.")
    public void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("입력값을 쉼표로 구분하여 모두 합한 값을 반환하는지 확인한다.")
    public void splitAndSum_쉼표구분자() {
        int result = StringAddCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("입력값을 쉼표 또는 콜론으로 구분하여 모두 합한 값을 반환하는지 확인한다.")
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분하여 모두 합한 값을 반환하는지 확인한다.")
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("입력값에 음수가 존재할 경우 예외를 발생시키는지 확인한다.")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값에 문자가 존재할 경우 예외를 발생시키는지 확인한다.")
    public void splitAndSum_character() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1,2,Z"))
                .isInstanceOf(RuntimeException.class)
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}