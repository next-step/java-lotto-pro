package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @DisplayName("Number_정상_입력")
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "1000"})
    void Number_정상_입력(String text) {
        assertThatNoException().isThrownBy(() -> new Number(text));
    }

    @DisplayName("Number_숫자_아니면_에러")
    @ParameterizedTest
    @ValueSource(strings = {",", "a", "a1", ""})
    void Number_숫자_아니면_에러(String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("Number_숫자_0_미만이면_에러")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1000"})
    void Number_숫자_0_미만이면_에러(String text) {
        assertThatThrownBy(() -> new Number(text))
                .isInstanceOf(RuntimeException.class);
    }


    @DisplayName("Number_숫자_equal_test")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "100:100:true", "0:100:false"}, delimiter = ':')
    void Number_숫자_equal_test(String num, String otherNum, boolean expected) {
        Number number = new Number(num);
        Number otherNumber = new Number(otherNum);
        assertThat(number.equals(otherNumber)).isEqualTo(expected);
    }
}
