import StringAddCalculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("null 또는 빈 문자열을 전달한 경우")
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1,", ",1", ",1,"})
    @DisplayName("숫자(문자열) 하나를 전달한 경우")
    void splitAndSum_숫자_하나(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,2,", ",1,2", ",1,2,"})
    @DisplayName("쉼표로 구분한 숫자들을 전달한 경우")
    void splitAndSum_쉼표_구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1:2,3", ",1,2:3,", ",1,2:3:", ":1,2:3,", ":1,2:3:"})
    @DisplayName("쉼표 또는 콜론으로 구분한 숫자들을 전달한 경우")
    void splitAndSum_쉼표_또는_콜론_구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분한 숫자들을 전달한 경우")
    void splitAndSum_커스텀_구분자_1() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자, 쉼표, 콜론을 함께 사용하여 구분한 숫자들을 전달한 경우")
    void splitAndSum_커스텀_구분자_2() {
        int result = StringAddCalculator.splitAndSum("//-\n1,2-3:4");
        assertThat(result).isEqualTo(10);
    }

    @Test
    @DisplayName("음수를 전달한 경우")
    void splitAndSum_음수() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,b,3", "1:2,-"})
    @DisplayName("숫자 이외의 값을 전달한 경우")
    void splitAndSum_숫자_이외(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
