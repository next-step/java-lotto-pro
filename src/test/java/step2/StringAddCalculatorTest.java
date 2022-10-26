package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {


    @Test
    @DisplayName("null값을 입력하면 0을 반환")
    public void returns_0_if_null_value_input() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("빈값을 입력하면 0을 반환")
    public void returns_0_if_empty_value_input() {
        int result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"12:12", "13:13", "3:3"}, delimiter = ':')
    @DisplayName("숫자만 입력할 경우 입력한 숫자 반환")
    public void returns_number_if_only_number_entered(String text,int value){
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(value);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "6,4,3:13", "7,2,9:18", "0,5,9:14"}, delimiter = ':')
    @DisplayName("숫자를 컴마(,) 구분자로 입력할 경우 숫자의 합을 반환")
    public void returns_sum_if_number_entered_with_comma(String text,int sum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2=3", "6:4,3=13", "7:2:9=18", "0,5:9=14"}, delimiter = '=')
    @DisplayName("숫자를 컴마(,)또는콜론(:) 구분자로 입력할 경우 숫자의 합을 반환")
    public void returns_sum_if_number_entered_with_comma_or_delimiter(String text, int sum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @Test
    @DisplayName("커스텀 구분자를 지정할 경우 구분된 숫자의 합을 반환")
    public void returns_sum_if_number_entered_with_custom_delimite1r()  {
        int result = StringAddCalculator.splitAndSum("//@\n1@2@3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("구분된 숫자중 음수가 포함된 경우 RuntimeException 예외를 발생")
    public void throw_exception_if_netative_number_included() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("구분된 문자열에 숫자 이외에 값이 포함된 경우 RuntimeException 예외를 발생")
    public void throw_exception_if_text_contains_value_other_than_number() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("31,a,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
