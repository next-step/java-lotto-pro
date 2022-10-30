package lotto.model.winning.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumbersTest {
    @Nested
    @DisplayName("WinningNumbers 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1, 11, 22, 33, 44, 45", "39, 28, 17, 6, 3, 2"})
        @DisplayName("당첨 번호 입력값을 제대로 입력하면 WinningNumbers 객체 생성 성공")
        void success(String input) {
            assertDoesNotThrow(() -> new WinningNumbers(input));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("당첨 번호 입력값이 null 또는 \"\"(empty string) 이면 예외 발생")
        void errorNullOrEmpty(String input) {
            assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {", 1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6, ", ", 1, 2, 3, 4, 5, 6, "})
        @DisplayName("쉼표가 당첨 번호 입력값의 맨 앞 또는 맨 뒤에 오면 예외 발생")
        void errorCommaAtStartOrAtEnd(String input) {
            assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
        }

        @ParameterizedTest
        @ValueSource(strings = {"1", "1, 2", "1, 2, 3", "1, 2, 3, 4", "1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7",
                "1, 2, 3, 4, 5, 6, 7, 8", "1, 2, 3, 4, 5, 6, 7, 8, 9", "1, 2, 3, 4, 5, 6, 7, 8, 9, 10"})
        @DisplayName("당첨 번호 개수가 6 이 아닐 경우 예외 발생")
        void errorNumberCountNotSix(String input) {
            assertThrows(IllegalArgumentException.class, () -> new WinningNumbers(input));
        }
    }
}
