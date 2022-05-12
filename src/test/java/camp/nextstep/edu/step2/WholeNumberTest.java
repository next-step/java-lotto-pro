package camp.nextstep.edu.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

public class WholeNumberTest {

    @DisplayName("정수를 입력받고 VO 객체이다")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:2:false"}, delimiter = ':')
    void createTest(final String source, final String destination, final boolean expectedResult) {
        assertThat(Objects.equals(new WholeNumber(source), new WholeNumber(destination))).isEqualTo(expectedResult);
    }

    @DisplayName("String 숫자가 아닌 값을 입력하면 RuntimeException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1.2", "a"})
    void invalidInputTest(final String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new WholeNumber(input));
    }

    @DisplayName("String 숫자가 음수인 경우 RuntimeException 이 발생")
    @Test
    void negativeInputTest() {
        assertThatThrownBy(() -> new WholeNumber("-1"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("negative input is");
    }

    @DisplayName("add 함수를 통해서 WholeNumber 끼리 더할수 있다")
    @ParameterizedTest
    @CsvSource(value = {"2:2:4", "4:2:6"}, delimiter = ':')
    void addTest(final String first, final String second, final String expectedNumber) {
        assertThat(new WholeNumber(first).add(new WholeNumber(second)))
                .isEqualTo(new WholeNumber(expectedNumber));
    }

    @DisplayName("of 메소드를 통해서 현재 상태 값을 리턴한다")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2"}, delimiter = ':')
    void ofTest(final String strNumber, final int expectedInteger) {
        assertThat(new WholeNumber(strNumber).value()).isEqualTo(expectedInteger);
    }
}
