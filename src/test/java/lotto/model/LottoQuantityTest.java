package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoQuantityTest {
  @Test
  void 로또_갯수를_가진다() {
    LottoQuantity lottoQuantity = new LottoQuantity(14);

    assertThat(lottoQuantity.getLottoQuantity()).isEqualTo(14);
  }
}
