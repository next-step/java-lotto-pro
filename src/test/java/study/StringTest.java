package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
  @Test
  @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
  public void split_learning_test_1() {
    // given
    String data = "1,2";

    // when
    String[] splitData = data.split(",");

    // then
    Assertions.assertThat(splitData).contains("1", "2");
  }

  @Test
  @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인한다.")
  public void split_learning_test_2() {
    // given
    String data = "1";

    // when
    String[] splitData = data.split(",");

    // then
    Assertions.assertThat(splitData).containsExactly("1");
  }
}
