package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoQuantityTest {
  @Test
  void 총_수량과_수동_로또_수량으로_자동_로또_수량을_구한다() {
    TotalLottoQuantity totalLottoQuantity = new TotalLottoQuantity(11);
    ManualLottoQuantity manualLottoQuantity = new ManualLottoQuantity(5);

    assertThat(totalLottoQuantity.calculateAutoLottoQuantity(manualLottoQuantity)).isEqualTo(new AutoLottoQuantity(6));
  }

}