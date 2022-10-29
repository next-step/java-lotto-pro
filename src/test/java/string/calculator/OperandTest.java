package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperandTest {
    @Nested
    @DisplayName("Operand 생성자 테스트")
    class OperandConstructor {
        @ParameterizedTest
        @ValueSource(strings = {"0", "1", "20", "5555", "2147483647"})
        @DisplayName("Operand 객체를 성공적으로 생성할 수 있다")
        void createOperand(String token) {
            assertDoesNotThrow(() -> new Operand(token));
        }

        @ParameterizedTest
        @ValueSource(strings = {"-2147483648", "-9999", "-5", "-2", "-1"})
        @DisplayName("음수 값으로 Operand 객체를 생성하려고 하면 예외가 발생한다")
        void cannotCreateOperandIfNegative(String token) {
            assertThrows(RuntimeException.class, () -> new Operand(token));
        }

        @ParameterizedTest
        @ValueSource(strings = {"a", "b", "c", "abc", ".", "|", "?"})
        @DisplayName("숫자가 아닌 값으로 Operand 객체를 생성하려고 하면 예외가 발생한다")
        void cannotCreateOperandIfNonDigit(String token) {
            assertThrows(RuntimeException.class, () -> new Operand(token));
        }
    }

    @Nested
    @DisplayName("add 메서드 테스트")
    class Add {
        @ParameterizedTest
        @CsvSource(value = {"1,2,3", "1,9,10", "0,0,0", "444,555,999"}, delimiter = ',')
        @DisplayName("두 개의 Operand 를 더한 결과로 새로운 Operand 객체를 얻을 수 있다")
        void addTest(String left, String right, String result) {
            Operand opLeft = new Operand(left);
            Operand opRight = new Operand(right);
            Operand opResult = opLeft.add(opRight);
            assertThat(opResult).isEqualTo(new Operand(result));
        }
    }
}
