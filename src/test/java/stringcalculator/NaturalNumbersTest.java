package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("계산할 숫자들이")
public class NaturalNumbersTest {
  @DisplayName("여러개일 경우 각 값의 합계를 반환하게된다.")
  @Test
  void  sum_multiValue() {
    // given
      List<NaturalNumber> tempCalculratorNumbers = new ArrayList<>();
      tempCalculratorNumbers.add(new NaturalNumber("2"));
      tempCalculratorNumbers.add(new NaturalNumber("1"));

      NaturalNumbers calculatorNumbers = new NaturalNumbers(tempCalculratorNumbers);

    // when
      Integer realValue = calculatorNumbers.sum();

    // then
      assertThat(realValue).isEqualTo(3);
  }

  @DisplayName("없을 경우 0을 반환하게된다.")
  @Test
  void sum_none() {
    // given
      List<NaturalNumber> tempCalculratorNumbers = new ArrayList<>();

      NaturalNumbers calculatorNumbers = new NaturalNumbers(tempCalculratorNumbers);

    // when
      Integer realValue = calculatorNumbers.sum();

    // then
      assertThat(realValue).isZero();
  }
}
