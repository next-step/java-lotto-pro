package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {


  @DisplayName("로또 번호들을 출력한다..")
  @Test
  void gerate_lottonumbers_auto() {
    // given
    LottoNumbers lottoNumbers = LottoNumbers.valueOf("1", "3", "5", "7", "9" , "20");
    Lotto lotto = new Lotto(lottoNumbers);

    // when

    // then
    assertThat(lotto.toString()).isEqualTo("1, 3, 5, 7, 9, 20");
  }
}
