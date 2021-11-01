package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
  private Set<Integer> numbers;

  @BeforeEach
  void setUp() {
    numbers = new HashSet<>();
    numbers.add(1);
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
  }

  @Test
  @DisplayName("Set.size 메소드를 활용하여 Set의 크기를 확인한다.")
  void size_learning_test() {
    assertThat(numbers.size()).isEqualTo(3);
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3})
  @DisplayName("Set.contains 메소드를 활용하여 파라미터가 Set에 포함되어 있는지 확인한다.")
  void contains_learning_test_1(int value) {
    assertThat(numbers.contains(value)).isTrue();
  }

  @ParameterizedTest
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
  @DisplayName("Set.contains 메소드를 활용하여 파라미터에 따라 true/false가 반환되는지 확인한다.")
  void contains_learning_test_2(int value, boolean isContains) {
    assertThat(numbers.contains(value)).isEqualTo(isContains);
  }
}
