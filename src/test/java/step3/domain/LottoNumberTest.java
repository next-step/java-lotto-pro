package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 45, 10})
  @DisplayName("로또 숫자가 범위(1~45) 안에 있는지 확인 - 성공")
  void checkLottoNumberBetween1And45(int number) {
    LottoNumber lottoNumber = new LottoNumber(number);
    assertThat(lottoNumber.getNumber()).isEqualTo(number);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46, -1})
  @DisplayName("로또 숫자가 범위(1~45) 안에 있는지 확인 - 실패")
  void checkLottoNumberBetween1And45_fail(int number) {
    assertThatThrownBy(() -> new LottoNumber(number))
        .isInstanceOf(RuntimeException.class);
  }
}
