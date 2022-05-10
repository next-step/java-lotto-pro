package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {

    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("splitAndSum_문자열이 숫자가 아닐경우 RuntimeException을 발생시킨다.")
    void splitAndSumIsNotNumberError() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1a,2:3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }


    @Test
    void splitAndSum_custom_구분자() throws Exception {
        assertAll(()-> {
            assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
            assertThat(StringAddCalculator.splitAndSum("//,\n1,2,3")).isEqualTo(6);
        });
    }

}
