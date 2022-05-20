package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a", "%"})
    @DisplayName("음수 또는 숫자 이외의 값 입력 시 Exception 발생 확인")
    public void validate(String input) throws Exception {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Number 합 연산 테스트")
    public void number_add() {
        Number number = new Number("1");
        number.add(new Number("2"));
        assertThat(number.getNumber()).isEqualTo(3);
    }
}
