package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperandTest {
    @Nested
    @DisplayName("Operand 생성자 테스트")
    class OperandConstructor {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 20, 5555, Integer.MAX_VALUE})
        @DisplayName("Operand 객체를 성공적으로 생성할 수 있다")
        void createOperand(int value) {
            assertDoesNotThrow(() -> new Operand(value));
        }

        @ParameterizedTest
        @ValueSource(ints = {Integer.MIN_VALUE, -9999, -5, -2, -1})
        @DisplayName("음수 값으로 Operand 객체를 생성하려고 하면 예외가 발생한다")
        void cannotCreateOperandIfNegative(int value) {
            assertThrows(RuntimeException.class, () -> new Operand(value));
        }
    }
}
