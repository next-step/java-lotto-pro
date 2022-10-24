package step1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Set Collection 에 대한 학습 테스트")
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

  @DisplayName(" Set 의 size() 를 이용하여 크기 반환되는지 확인")
  @Test
  void size() {
    // given, when
    int size = numbers.size();
    // then
    assertThat(size).isEqualTo(3);
  }

  @DisplayName("Set 의 contains() 를 이용하여 특정 값이 존재하는지 확인")
  @ParameterizedTest(name = "{index}번째: {0} 일 때 존재 확인")
  @ValueSource(ints = {1, 2, 3})
  void set_contains_ParameterizedTest(int value) {
    // given, when, then
    assertThat(numbers.contains(value)).isTrue();
  }

  @DisplayName("CsvSource 를 이용하여 입력 값에 따라 다른 결과 값을 확인하는 테스트")
  @ParameterizedTest(name = "{index}번째: {0} 일 때, 결과 값: {1} 확인")
  @CsvSource(value = {"1:true", "2:true", "3:true", "4:false"}, delimiter = ':')
  void set_contains_CsvSource_ParameterizedTest(int number, boolean result) {
    // given, when, then
    assertThat(numbers.contains(number)).isEqualTo(result);
  }



}
