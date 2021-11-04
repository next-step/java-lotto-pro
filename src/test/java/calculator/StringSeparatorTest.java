package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSeparatorTest {
  @DisplayName("문자열을 커스텀 구분자로 구분한다.")
  @Test
  void splitByCustomDelimiter() {
    String input = "//;\n2;3;4;5";
    String[] splitStrings = StringSeparator.split(input);
    assertThat(splitStrings).containsExactly("2", "3", "4", "5");
  }

  @DisplayName("문자열을 기본 구분자로 구분한다.")
  @Test
  void splitByDefaultDelimiter() {
    String input = "2,3:4,5";
    String[] splitStrings = StringSeparator.split(input);
    assertThat(splitStrings).containsExactly("2", "3", "4", "5");
  }
}