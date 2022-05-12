package camp.nextstep.edu.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class WholeNumberTest {

    @DisplayName("정수를 입력받고 VO 객체이다")
    @ParameterizedTest
    @CsvSource(value = {"1:1:true", "1:2:false"}, delimiter = ':')
    void createTest(final int source, final int destination, final boolean expectedResult) {
        assertThat(Objects.equals(new WholeNumber(source), new WholeNumber(destination))).isEqualTo(expectedResult);
    }

    @DisplayName("String 숫자가 아닌 값을 입력하면 RuntimeException 이 발생")
    @ParameterizedTest
    @ValueSource(strings = {"1.2", "a"})
    void invalidInputTest(final String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new WholeNumber(input));
    }
}
