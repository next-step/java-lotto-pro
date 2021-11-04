package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {
  @DisplayName("null 또는 공백 문자열이 오면 0을 반환한다.")
  @ParameterizedTest
  @NullAndEmptySource
  public void splitAndSum_null_또는_빈문자(String input) {
    int result = StringAddCalculator.splitAndSum(input);
    assertThat(result).isEqualTo(0);
  }


  @DisplayName("입력값으로 숫자만 입력받을 경우 해당 숫자를 리턴한다.")
  @ParameterizedTest
  @ValueSource(strings = {"1", "2345", "0"})
  public void splitAndSum_숫자하나(String input) throws Exception {
    int result = StringAddCalculator.splitAndSum(input);
    assertThat(result).isEqualTo(Integer.parseInt(input));
  }

  @DisplayName("기본 구분자인 쉼표 구분자로 split 하여 sum 한다.")
  @Test
  public void splitAndSum_쉼표구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2");
    assertThat(result).isEqualTo(3);
  }

  @DisplayName("기본 구분자인 쉼표 또는 콜론 구분자로 split 하여 sum 한다.")
  @Test
  public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("1,2:3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("커스텀 구분자로 split 하여 sum 한다.")
  @Test
  public void splitAndSum_custom_구분자() throws Exception {
    int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
    assertThat(result).isEqualTo(6);
  }

  @DisplayName("입력값에 음수가 있을 경우 예외를 던진다.")
  @Test
  public void splitAndSum_negative() throws Exception {
    String input = "-1,2,3";

    Throwable thrown = catchThrowable(() -> StringAddCalculator.splitAndSum(input));

    assertThat(thrown)
      .isInstanceOf(RuntimeException.class)
      .hasMessage(ErrorMessage.NEGATIVE_NUMBER_ERROR);

    assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
      .isInstanceOf(RuntimeException.class)
      .hasMessage(ErrorMessage.NEGATIVE_NUMBER_ERROR);
  }
}
