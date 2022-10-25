package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    private static final String PARAMETERIZED_TEST_NAME_FORMAT = "[{displayName}] {index} -> {arguments}";

    @DisplayName("NULL 또는 빈 문자")
    @ParameterizedTest(name = PARAMETERIZED_TEST_NAME_FORMAT)
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(0);
    }

    @DisplayName("숫자를 하나만 전달할 경우")
    @ParameterizedTest(name = PARAMETERIZED_TEST_NAME_FORMAT)
    @ValueSource(strings = {"1", "2", "3"})
    void splitAndSum_숫자하나(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName("NULL 또는 빈 문자를 입력 시 0")
    @Test
    void splitAndSum_쉼표구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 사용 할 경우")
    @ParameterizedTest(name = PARAMETERIZED_TEST_NAME_FORMAT)
    @ValueSource(strings = {"//;\n1;2;3", "//'\n1'2'3", "//!\n1!2!3"})
    public void splitAndSum_custom_구분자(String text) {
        assertThat(StringAddCalculator.splitAndSum(text)).isEqualTo(6);
    }

    @DisplayName("음수가 포함된 경우")
    @ParameterizedTest(name = PARAMETERIZED_TEST_NAME_FORMAT)
    @ValueSource(strings = {"-1,2,3", "1,-2,3", "1,2,-3", "-1,-2,-3"})
    public void splitAndSum_negative(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("숫자가 아닌 문자가 포함된 경우")
    @ParameterizedTest(name = PARAMETERIZED_TEST_NAME_FORMAT)
    @ValueSource(strings = {"A", "1,!", "1,2,B"})
    public void splitAndSum_숫자가_아닌_문자(String text) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(text))
                .isInstanceOf(RuntimeException.class);
    }
}