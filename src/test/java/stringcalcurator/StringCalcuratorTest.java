package stringcalcurator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Nested;

public class StringCalcuratorTest {
  @DisplayName("구분자들에대해")
  @Nested
  class SeperatorsTest {
    @DisplayName("저장된 값이 문자열 결합으로 반환된다.")
    @Test
    void return_allSeperator() {
      // given
      List<Separator> tempSeparators = new ArrayList<>();
      tempSeparators.add(new Separator(","));
      tempSeparators.add(new Separator(":"));
  
      // when
      Separators separators = new Separators(tempSeparators);

      // then
      assertThat(separators.getSeparators()).isEqualTo(",:");
    }

    @DisplayName("기본구분자가 있을 때 추가적으로 커스텀 구분자가 추가된다.")
    @Test
    void add_seperatorWithDefault() {
      // given
      List<Separator> tempSeparators = new ArrayList<>();
      tempSeparators.add(new Separator(","));
      tempSeparators.add(new Separator(":"));
      Separators separators = new Separators(tempSeparators);

      // when
      separators.add(new Separator("@"));

      // then
      assertThat(separators.getSeparators()).isEqualTo(",:@");
    }
  }

  @DisplayName("계산할 숫자들이")
  @Nested
  class CalculratorNumbersTest {
    @DisplayName("여러개일 경우 각 값의 합계를 반환하게된다.")
    @Test
    void  sum_multiValue() {
      // given
        List<CalcuratorNumber> tempCalculratorNumbers = new ArrayList<>();
        tempCalculratorNumbers.add(new CalcuratorNumber("2"));
        tempCalculratorNumbers.add(new CalcuratorNumber("1"));

        CalcuratorNumbers calcuratorNumbers = new CalcuratorNumbers(tempCalculratorNumbers);

      // when
        Integer realValue = calcuratorNumbers.sum();

      // then
        assertThat(realValue).isEqualTo(3);
    }
    
    @DisplayName("없을 경우 0을 반환하게된다.")
    @Test
    void sum_none() {
      // given
        List<CalcuratorNumber> tempCalculratorNumbers = new ArrayList<>();

        CalcuratorNumbers calcuratorNumbers = new CalcuratorNumbers(tempCalculratorNumbers);

      // when
        Integer realValue = calcuratorNumbers.sum();

      // then
        assertThat(realValue).isZero();
    }
  }
  
  @DisplayName("계산할 숫자가")
  @Nested
  class CalculratorNumberTest {
    @DisplayName("음수이거나 숫자가 아닐경우 RuntimeException이 발생된다.")
    @ValueSource(strings = {"-1", "a", "A", "!", "|"})
    @ParameterizedTest(name = "{index} => String Value [{0}]")
    void numberInvalid(String value) {
      // given
      // when
      ThrowingCallable exceptionContent = () -> new CalcuratorNumber(value);
      
      // then
      assertThatExceptionOfType(RuntimeException.class)
        .isThrownBy(exceptionContent);
      
    }
  }
}
