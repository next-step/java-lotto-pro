package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {
  @DisplayName("로또번호가 같을시 일치하는지 여부를 알수있다.")
  @Test
  void get_buyLotto_sumPrice() {
    // given
    LottoNumber lottoNumber1 = LottoNumber.valueOf("2");
    LottoNumber lottoNumber2 = LottoNumber.valueOf("2");
    // when

    Boolean realisEqual = lottoNumber1.equals(lottoNumber2);

    // then
    assertThat(realisEqual).isTrue();
  }

  @DisplayName("유요하지 않은 번호로 생성시 오류 발생")
  @Test
  void check_invalidLottoNumber() {
    // given

    // when
		ThrowingCallable exceptionContent = () -> {LottoNumber.valueOf("50");};

    // then
		assertThatExceptionOfType(IllegalArgumentException.class)
    .isThrownBy(exceptionContent)
    .withMessageMatching("유효하지 않은 로또 번호입니다.");
  }
}
