import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("NULL 을 입력하면 0 을 반환한다.")
    public void splitAndSum_null_return_zero() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈문자를 입력하면 0 을 반환한다.")
    public void splitAndSum_빈문자_return_zero() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나만 입력할 경우")
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표구분자로 나누어진 2개의 숫자의 합")
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표구분자, 콜론 구분자로 나누어진 3개의 숫자의 합")
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자, 쉼표구분자, 콜론 구분자로 나누어진 숫자의 합")
    public void splitAndSum_custom_구분자() throws Exception {
        String t = "//;\n1;2;3";
        int result = StringAddCalculator.splitAndSum(t);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 넣게 되면 오류를 리턴한다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
