package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("Null 또는 빈문자일때 0을 반환한다.")
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자가 하나 일 경우 숫자 하나가 반환된다.")
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("쉼표 구분인 합")
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("쉼표 또는 콜론 구분인 합")
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum_문자열이 숫자가 아닐경우 RuntimeException을 발생시킨다.")
    void splitAndSumIsNotNumberError() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1a,2:3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Message.ONLY_NUMBER_TEXT.getMessage());
    }

    @Test
    @DisplayName("splitAndSum_문자열이 음수가 아닐경우 RuntimeException을 발생시킨다.")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(Message.ONLY_POSITIVE_NUMBER_TEXT.getMessage())
        ;
    }


    @Test
    @DisplayName("커스텀한 구분자의 합")
    void splitAndSum_custom_구분자() throws Exception {
        assertAll(()-> {
            assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
            assertThat(StringAddCalculator.splitAndSum("//,\n1,2,3")).isEqualTo(6);
        });
    }

}
