package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositiveNumbersTest {
    private static final String NON_POSITIVE_NUMBER_MESSAGE = "음수나 문자열은 사용할 수 없습니다.";

    @DisplayName("문자열 배열로 PositiveNumbers 생성 테스트")
    @Test
    void createPositiveNumbers() {
        PositiveNumbers positiveNumbers = new PositiveNumbers(new String[] {"1", "2", "3"});
        assertNotNull(positiveNumbers);
    }

    @DisplayName("음수나 문자열이 포함된 문자열 배열로 PositiveNumbers 생성 테스트")
    @Test
    void createPositiveNumbersException() {
        assertThatThrownBy(() -> new PositiveNumbers(new String[] {"1", "a"}))
            .isInstanceOf(RuntimeException.class)
            .hasMessage(NON_POSITIVE_NUMBER_MESSAGE);

        assertThatThrownBy(() -> new PositiveNumbers(new String[] {"1", "-1"}))
            .isInstanceOf(RuntimeException.class)
            .hasMessage(NON_POSITIVE_NUMBER_MESSAGE);
    }

    @DisplayName("숫자 더하기")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3,5:20-31", "5,10:15-30"}, delimiter = '-')
    void addTest(String text, int expected) {
        PositiveNumbers positiveNumbers = new PositiveNumbers(TextSplit.split(text));
        int sum = positiveNumbers.sum();
        assertEquals(expected, sum);
    }
}
