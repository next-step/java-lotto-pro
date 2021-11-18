package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseAmountTest {
  @Test
  void 금액_지불() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(14000);
  }

  @Test
  void 금액_만큼_구매한_로또_갯수_반환() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    assertThat(purchaseAmount.countOfPurchaseLotto()).isEqualTo(new LottoQuantity(14));
  }
}
