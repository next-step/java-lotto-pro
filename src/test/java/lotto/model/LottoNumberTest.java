package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
  @DisplayName("1 - 45 범위사이 로또 번호를 생성한다.")
  @Test
  void 로또_번호_생성() {
    int number = 45;

    LottoNumber lottoNumber = new LottoNumber(number);

    assertThat(lottoNumber.getLottoNumber()).isEqualTo(number);
  }

  @DisplayName("1 - 45 범위 밖의 번호로 로또 번호를 생성할 경우 예외 처리한다.")
  @ParameterizedTest
  @ValueSource(ints = {-1, 0, 46})
  void 로또_번호_범위_유효성_체크(int number) {
    Throwable thrown = catchThrowable(() -> new LottoNumber(number));

    assertThat(thrown)
      .isInstanceOf(NumberOutOfRangeException.class)
      .hasMessage(ErrorMessage.NUMBER_OUT_OF_RANGE_ERROR_MESSAGE);
  }

}