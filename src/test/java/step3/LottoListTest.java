package step3;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.LottoList;
import org.junit.jupiter.api.Test;

public class LottoListTest {

  @Test
  void test() {
    //given
    int amount = 14;
    //when
    LottoList lottoList = new LottoList(amount);
    //then
    assertThat(lottoList.getLottoList().size()).isEqualTo(14);
  }

}
