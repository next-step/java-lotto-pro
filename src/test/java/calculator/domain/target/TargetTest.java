package calculator.domain.target;

import static calculator.domain.target.validation.CalculatorValidator.ERROR_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TargetTest {

    Target target;

    @Test
    void null_empty() {
        target = new Target(null);
        assertThat(target.target()).contains(0);

        target = new Target("");
        assertThat(target.target()).contains(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1 ; 2; 3 ", "// \n1 2 3", "//@\n 1 @2 @ 3"})
    void custom_split(String data) {
        target = new Target(data);
        int[] result = target.target();
        assertThat(result).contains(1, 2, 3);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = " 1 , 2:3 ")
    void comma_colon_split(String data) {
        target = new Target(data);
        int[] result = target.target();
        assertThat(result).contains(1, 2, 3);
        assertThat(result).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = " 1: 2")
    void colon_split(String data) {
        target = new Target(data);
        int[] result = target.target();
        assertThat(result).contains(1, 2);
        assertThat(result).containsExactly(1, 2);
    }

    @ParameterizedTest
    @ValueSource(strings = " 1 , 2 ")
    void comma_split(String data) {
        target = new Target(data);
        int[] result = target.target();
        assertThat(result).contains(1, 2);
        assertThat(result).containsExactly(1, 2);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "-", "%"})
    void 숫자_아니면_EX(String data) {
        target = new Target(data);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> target.target())
                .withMessageContaining(ERROR_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void 음수라면_EX(String data) {
        target = new Target(data);
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> target.target())
                .withMessageContaining(ERROR_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("양수(0포함)라면 통과")
    @ValueSource(strings = {"0", "1", "2"})
    void 양수라면_통과(String data) {
        target = new Target(data);
        assertThatNoException().isThrownBy(() -> target.target());
    }
}
