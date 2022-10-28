package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
    }
}
