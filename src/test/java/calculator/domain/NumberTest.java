package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1,1", "0,0", "90,90", " "
    })
    @DisplayName("문자 검증 - 성공")
    public void numberValidationTest_ok(String input, int result){
        int number = new Number(input).getNumber();

        assertThat(number).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "a","-1",":"
    })
    @DisplayName("문자 검증 - 실패")
    public void numberValidationTest_fail(String input){
        assertThatThrownBy(() -> new Number(input)).isInstanceOf(RuntimeException.class);
    }
}
