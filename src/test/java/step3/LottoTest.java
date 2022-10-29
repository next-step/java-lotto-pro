package step3;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
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

  @Test
  @DisplayName("로또끼리 비교를 하여 동일한 값의 개수를 주는지 확인")
  void 로또_비교() {
    //given
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto targetLotto = new Lotto(List.of(4, 5, 6, 7, 8, 9));
    //when
    int count = lotto.countMatchingNumber(targetLotto);
    //then
    assertThat(count).isEqualTo(3);
  }

}
