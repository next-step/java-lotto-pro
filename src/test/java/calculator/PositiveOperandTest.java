package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositiveOperandTest {

    @DisplayName("PositiveOperand 생성 성공")
    @Test
    void createSuccess() {
        //given:
        String operand = "10";
        //when, then:
        assertThatNoException().isThrownBy(() -> new PositiveOperand(operand));
    }

    @DisplayName("PositiveOperand getIntValue 메서드 테스트")
    @Test
    void getIntValue() {
        //given:
        String operand = "10";
        //when:
        PositiveOperand operand = new PositiveOperand(operand);
        //then:
        assertThat(operand.getOperand()).isEqualTo(10);
    }

    @DisplayName("PositiveOperand 생성 실패 - 숫자형 데이터가 아닌 경우")
    @Test
    void createFailNumberFormat() {
        assertThatThrownBy(() -> new PositiveOperand("mingvel"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("PositiveOperand 생성 실패 - 음수")
    @Test
    void createFailNegative() {
        assertThatThrownBy(() -> new PositiveOperand("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
