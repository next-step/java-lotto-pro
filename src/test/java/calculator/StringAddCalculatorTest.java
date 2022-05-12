package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 null인 경우 0이 반환된다.")
    void emptyCase01() {
        // given
        String text = null;

        // when
        Integer sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 공백인 경우 0이 반환된다.")
    void emptyCase02() {
        // given
        String text = "";

        // when
        Integer sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 숫자가 아닌경우 RuntimeException이 발생된다.")
    void exceptionTest01() {
        // given
        String text = "a,f,!";

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("a, f, !");
    }

    @Test
    @DisplayName("문자열 계산기에 전달된 값이 음수 인 경우 RuntimeException이 발생된다.")
    void exceptionTest02() {
        // given
        String text = "-1,2,3";

        // when & then
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("[ERROR]")
            .hasMessageContaining("-1, 2, 3");
    }

    @Test
    @DisplayName("문자열 계산기 합산 테스트")
    void sumTest01() {
        // given
        String text = "1,2:3";

        // when
        Integer sum = StringAddCalculator.splitAndSum(text);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    @DisplayName("문자열 계산기 합산 테스트 (기본 구분자) ParameterizedTest 활용")
    void sumTest02(String input) {
        // given & when
        Integer sum = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//_\n1_2_3"})
    @DisplayName("문자열 계산기 합산 테스트 (커스텀 구분자) ParameterizedTest 활용")
    void sumTest03(String input) {
        // given & when
        Integer sum = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(sum).isEqualTo(6);
    }


    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}