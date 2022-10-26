package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OperandTest {

    @DisplayName("Operand 생성 성공")
    @Test
    void createSuccess() {
        //given:
        String source = "10";
        //when:
        Operand operand = new Operand(source);
        //then:
        assertThat(operand).isNotNull();
    }

    @DisplayName("Operand getIntValue 메서드 테스트")
    @Test
    void getIntValue() {
        //given:
        String source = "10";
        //when:
        Operand operand = new Operand(source);
        //then:
        assertThat(operand.getIntValue()).isEqualTo(10);
    }

    @DisplayName("Operand 생성 실패 - 숫자형 데이터가 아닌 경우")
    @Test
    void createFailNumberFormat() {
        assertThatThrownBy(() -> new Operand("mingvel"))
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("Operand 생성 실패 - 음수")
    @Test
    void createFailNegative() {
        assertThatThrownBy(() -> new Operand("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}
