package step3;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoListTest {

  @Test
  @DisplayName("입력받은 amount 만큼 로또의 개수를 가지는 로또리스트 생성 확인")
  void 로또리스트_생성() {
    //given
    int amount = 14;
    //when
    LottoList lottoList = new LottoList(amount);
    //then
    assertThat(lottoList.getLottoList().size()).isEqualTo(14);
  }

}
