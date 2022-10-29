package lotto.model.winning.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4"})
    @DisplayName("문자열을 제대로 입력하면 WinningNumbers 객체가 파싱해서 멤버 변수로 저장한다")
    void constructorSuccess(String input) {
        assertDoesNotThrow(() -> new WinningNumbers(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {", 1, 2", "3, 4, ", ", 9, 10,"})
    @DisplayName("맨 앞 또는 맨 뒤에 ,(comma) 가 있으면 예외 발생")
    void constructorErrorCommaAtStartOrLast(String input) {
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 \"\"(empty string) 값을 입력하면 예외 발생")
    void constructorErrorNullOrEmpty(String input) {
        assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
    }
}
