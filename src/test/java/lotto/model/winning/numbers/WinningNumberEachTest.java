package lotto.model.winning.numbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WinningNumberEachTest {
    @Nested
    @DisplayName("WinningNumberEach 클래스 생성자 테스트")
    class Constructor {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 15, 39, 43, 44, 45})
        @DisplayName("1 이상 45 이하의 숫자를 사용하면 WinningNumberEach 객체 생성 성공")
        void success(int value) {
            final String token = String.valueOf(value);
            assertDoesNotThrow(() -> new WinningNumberEach(token));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -99999, -101, -2, -1, 0, 46, 47, 48, 140, 595959, Integer.MAX_VALUE})
        @DisplayName("1 보다 작은 숫자 또는 45 보다 큰 숫자를 사용하면 WinningNumberEach 객체 생성 실패")
        void errorLessThanOneOrGreaterThanFortyFive(int value) {
            final String token = String.valueOf(value);
            assertThrows(NumberFormatException.class, () -> new WinningNumberEach(token));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "c", "abc", "!", "`", "."})
        @DisplayName("숫자가 아닌 문자열을 사용하면 WinningNumberEach 객체 생성 실패")
        void errorNonDigit(String token) {
            assertThrows(NumberFormatException.class, () -> new WinningNumberEach(token));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null 또는 \"\"(empty string) 사용하면 WinningNumberEach 객체 생성 실패")
        void errorNullOrEmpty(String token) {
            assertThrows(NumberFormatException.class, () -> new WinningNumberEach(token));
        }
    }
}
