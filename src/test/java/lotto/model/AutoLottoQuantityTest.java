package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoQuantityTest {
  @Test
  void 총_수량과_수동_로또_수량으로_자동_로또_수량을_구한다() {
    LottoQuantity lottoQuantity = new LottoQuantity(11);
    ManualLottoQuantity manualLottoQuantity = new ManualLottoQuantity(5);

    assertThat(lottoQuantity.calculateAutoLottoQuantity(manualLottoQuantity)).isEqualTo(new AutoLottoQuantity(6));
  }

}