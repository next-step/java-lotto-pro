package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("계산할 숫자가")
public class NaturalNumberTest {
  @DisplayName("음수이거나 숫자가 아닐경우 RuntimeException이 발생된다.")
  @ValueSource(strings = {"-1", "a", "A", "!", "|"})
  @ParameterizedTest(name = "{index} => String Value [{0}]")
  void numberInvalid(String value) {
    // given

    // when
    ThrowingCallable exceptionContent = () -> new NaturalNumber(value);

    // then
    assertThatExceptionOfType(RuntimeException.class)
      .isThrownBy(exceptionContent);
  }
}
