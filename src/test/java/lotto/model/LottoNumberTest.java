package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 번호 테스트")
class LottoNumberTest {

  @DisplayName("로또번호 생성시 1~45 범위의 숫자가 아닌경우 예외처리 테스트")
  @ParameterizedTest(name = "index : {index}, outNumber : {0}")
  @ValueSource(ints = {0, 46, Integer.MAX_VALUE})
  void 로또번호_생성시_1_45범위의_숫자가_아닐경우_예외처리(int outNumber) {
    // given // when // then
    assertThatThrownBy(() -> {
      LottoNumber.from(outNumber);
    }).isInstanceOf(LottoException.class)
        .hasMessage("[ERROR] 로또 번호는 1~45까지 수만 입력 가능합니다.");
  }


  @DisplayName("로또번호 비교 테스트")
  @Test
  void 로또번호_비교_테스트() {
    // given
    int number1 = 5;
    int number2 = 4;

    // when
    LottoNumber lottoNumber1 = LottoNumber.from(number1);
    LottoNumber lottoNumber2 = LottoNumber.from(number1);
    LottoNumber lottoNumber3 = LottoNumber.from(number2);

    // then
    assertAll(
        () -> assertThat(lottoNumber1.equals(lottoNumber2)).isTrue(),
        () -> assertThat(lottoNumber1.equals(lottoNumber3)).isFalse()
    );
  }
}