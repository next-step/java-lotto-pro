package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {


    @Test
    @DisplayName("null 또는 비어있다면 0이어야한다.")
    void ifNullOrEmptyResultZero() {
        StringCalculator calculator = new StringCalculator("");
        assertThat(calculator.result()).isEqualTo(0);
        calculator = new StringCalculator(null);
        assertThat(calculator.result()).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 입력하는경우 바로 반환")
    void ifNumberIsOne() {
        StringCalculator calculator = new StringCalculator("3");
        assertThat(calculator.result()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void commaSplitSum() {
        StringCalculator calculator = new StringCalculator("3,4");
        assertThat(calculator.result()).isEqualTo(7);
    }

    @Test
    @DisplayName("컴마(,) 외에 콜론(:)을 사용하여 합을 수할 수 있다.")
    void colonAndCommaSplitSum() {
        StringCalculator calculator = new StringCalculator("1,2:3");
        assertThat(calculator.result()).isEqualTo(6);
    }

    @Test
    @DisplayName("컴스텀 구분자로 합을 구할 수 있다.")
    void customSplitSum() {
        StringCalculator calculator = new StringCalculator("//;\n1;2;3");
        assertThat(calculator.result()).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 입력 RuntimeException")
    void isNegativeThrow() {
        assertThatThrownBy(() -> {
            StringCalculator calculator = new StringCalculator("-1,2,3");
            calculator.result();
        }).isInstanceOf(RuntimeException.class);


    }


}
