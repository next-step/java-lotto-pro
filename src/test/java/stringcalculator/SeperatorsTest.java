package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("구분자들에대해")
public class SeperatorsTest {
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
    assertThat(separators.value()).isEqualTo(",:");
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
    assertThat(separators.value()).isEqualTo(",:@");
  }  
}
