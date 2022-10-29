package step3;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

  @Test
  @DisplayName("로또 번호 생성시 사이즈와 숫자 범위 확인")
  void 로또_생성() {
    //given //when
    Lotto lotto = new Lotto();

    //then
    assertAll(
        () -> assertThat(lotto.getNumbers().size()).isEqualTo(6),
        () -> lotto.getNumbers().forEach(
            number -> assertThat(number).isBetween(1, 45))
    );

  }

}
