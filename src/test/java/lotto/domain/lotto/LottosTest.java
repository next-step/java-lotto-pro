package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
  @DisplayName("로또를 산 전체 금액을 알 수 있다.")
  @Test
  void get_buyLotto_sumPrice() {
    // given
    Lottos lottos = Lottos.valueOf(Lotto.valueOf("1", "3", "5", "7", "9" , "20"),
                                    Lotto.valueOf("1", "3", "5", "7", "9" , "20"),
                                    Lotto.valueOf("1", "3", "5", "7", "9" , "20")
                                    );

    // when
    Integer buyLottoPrice = lottos.getPrice();

    // then
    assertThat(buyLottoPrice).isEqualTo(3000);
  }
}
