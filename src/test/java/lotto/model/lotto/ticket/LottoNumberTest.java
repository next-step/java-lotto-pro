package lotto.model.lotto.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTest {
    @Nested
    @DisplayName("LottoNumber 생성자 (String 파라미터) 테스트")
    class ConstructorString {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 15, 39, 43, 44, 45})
        @DisplayName("1 이상 45 이하의 문자열을 사용하면 LottoNumber 객체 생성 성공")
        void success(int value) {
            String token = String.valueOf(value);
            assertDoesNotThrow(() -> new LottoNumber(token));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -99999, -101, -2, -1, 0, 46, 47, 48, 140, 595959, Integer.MAX_VALUE})
        @DisplayName("1 보다 작은 숫자 또는 45 보다 큰 숫자를 사용하면 LottoNumber 객체 생성 실패")
        void errorLessThanOneOrGreaterThanFortyFive(int value) {
            String token = String.valueOf(value);
            assertThrows(NumberFormatException.class, () -> new LottoNumber(token));
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null 또는 \"\"(empty string) 사용하면 LottoNumber 객체 생성 실패")
        void errorNullOrEmpty(String token) {
            assertThrows(NumberFormatException.class, () -> new LottoNumber(token));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "c", "abc", "!", "`", ".", " "})
        @DisplayName("숫자가 아닌 문자열을 사용하면 LottoNumber 객체 생성 실패")
        void errorNonDigit(String token) {
            assertThrows(NumberFormatException.class, () -> new LottoNumber(token));
        }
    }

    @Nested
    @DisplayName("LottoNumber 생성자 (int 파라미터) 테스트")
    class ConstructorInt {
        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3, 15, 39, 43, 44, 45})
        @DisplayName("1 이상 45 이하의 정수를 사용하면 LottoNumber 객체 생성 성공")
        void success(int value) {
            assertDoesNotThrow(() -> new LottoNumber(value));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -99999, -101, -2, -1, 0, 46, 47, 48, 140, 595959, Integer.MAX_VALUE})
        @DisplayName("1 보다 작은 숫자 또는 45 보다 큰 숫자를 사용하면 LottoNumber 객체 생성 실패")
        void errorLessThanOneOrGreaterThanFortyFive(int value) {
            assertThrows(NumberFormatException.class, () -> new LottoNumber(value));
        }
    }
}
