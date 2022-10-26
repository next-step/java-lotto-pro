package step2;

import static calculator.StringSum.ERROR_MESSAGE_BY_NEGATIVE_INT_VALUE;
import static calculator.StringSum.ERROR_MESSAGE_BY_NOT_INT_VALUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.StringSum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSumTest {

  @DisplayName("숫자가 아닌 값이 전달되었을 경우 RunException 발생 확인 ")
  @Test
  void sum_exception_not_int_value() {
    //given
    String[] input = {"1", "test", "3"};
    //when, then
    assertThatThrownBy(
        () -> {
          StringSum result = new StringSum(input);
        }
    ).isInstanceOf(RuntimeException.class)
        .hasMessageContaining(ERROR_MESSAGE_BY_NOT_INT_VALUE);
  }

  @DisplayName("음수 인 값이 전달되었을 경우 RunException 발생 확인 ")
  @Test
  void sum_exception_negative_int_value() {
    //given
    String[] input = {"1", "-1", "3"};
    //when, then
    assertThatThrownBy(
        () -> {
          StringSum result = new StringSum(input);
        }
    ).isInstanceOf(RuntimeException.class)
        .hasMessageContaining(ERROR_MESSAGE_BY_NEGATIVE_INT_VALUE);
  }

  @DisplayName("정상적인 양수의 값이 전달되었을 경우 올바른 합 결과 확인")
  @Test
  void sum() {
    //given
    String[] input = {"1", "2", "3", "4"};
    //when
    StringSum result = new StringSum(input);
    //then
    assertThat(result.getSum()).isEqualTo(10);
  }

}
