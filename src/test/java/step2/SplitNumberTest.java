package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SplitNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "-1"})
    @DisplayName("양수가 아닌경우 예외발생")
    void splitNumber_예외(String input) {
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> {
                // when
                SplitNumber.valueOf(input);
            }) // then
            .withMessageMatching(SplitNumber.NOT_POSITIVE_NUMBER_MESSAGE);
    }
}
