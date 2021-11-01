package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
  @Test
  @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
  void split_learning_test_1() {
    // given
    String data = "1,2";

    // when
    String[] splitData = data.split(",");

    // then
    assertThat(splitData).contains("1", "2");
  }

  @Test
  @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
  void split_learning_test_2() {
    // given
    String data = "1";

    // when
    String[] splitData = data.split(",");

    // then
    assertThat(splitData).containsExactly("1");
  }

  @Test
  @DisplayName("(1,2) 값이 주어졌을 때 substring() 메소드를 활용해 ()을 제거하고 1,2가 반환되는지 확인한다.")
  void substring_learning_test() {
    // given
    String data = "(1,2)";

    // when
    String substringData = data.substring(1, 4);

    // then
    assertThat(substringData).isEqualTo("1,2");
  }

  @ParameterizedTest
  @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
  @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 정상적으로 가져오는지 확인한다.")
  void charAt_learning_test_1(int index, char expectedValue) {
    // given
    String data = "abc";

    // when
    char charAtData = data.charAt(index);

    assertThat(charAtData).isEqualTo(expectedValue);
  }

  @Test
  @DisplayName("charAt 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어날 경우 exception 발생을 확인한다.")
  void charAt_learning_test_2() {
    // given
    String data = "abc";

    // when
    Throwable thrown = catchThrowable(() -> data.charAt(3));

    // then
    assertThat(thrown)
      .isInstanceOf(StringIndexOutOfBoundsException.class)
      .hasMessageContaining("String index out of range: 3");

    assertThatThrownBy(() -> data.charAt(4))
      .isInstanceOf(StringIndexOutOfBoundsException.class)
      .hasMessageContaining("String index out of range: 4");

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
      .isThrownBy(() -> data.charAt(5))
      .withMessageMatching("String index out of range: 5");
  }
}
