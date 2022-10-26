package step2;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

import calculator.Split;
import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Split Test")
public class SplitTest {

  @DisplayName("빈 문자열 또는 null 값을 입력할 경우 [\"0\"] 을 반환 하는지 확인")
  @Test
  void split_null() {
    //given
    String input = "";
    //when
    Split result = new Split(input);
    //then
    assertThat(result.getValue()).isEqualTo(new String[] {"0"});
  }

  @DisplayName(" ',' 또는 ':' 기본 구분자로 입력할 경우 분리되는지 확인")
  @Test
  void split_default_split_separators() {
    //given
    String input = "1,2:3";
    //when
    Split result = new Split(input);
    //then
    assertThat(result.getValue()).isEqualTo(new String[] { "1", "2", "3" });
  }

  @DisplayName(" 커스텀 구분자로 입력할 경우 분리되는지 확인")
  @Test
  void split_custom_split_separator() {
    //given
    String input = "//;\n1;2;3";
    //when
    Split result = new Split(input);
    //then
    assertThat(result.getValue()).isEqualTo(new String[] { "1", "2", "3" });
  }





}
