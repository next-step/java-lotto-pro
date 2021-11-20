package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {
  @Test
  void 금액_지불() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(14000);
  }

  @Test
  void 금액_만큼_구매한_로또_갯수_반환() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);

    assertThat(purchaseAmount.countOfPurchaseLotto()).isEqualTo(new TotalLottoQuantity(14));
  }

  @Test
  void 구매_수량_음수_예외_처리() {
    assertThatThrownBy(() -> new PurchaseAmount(-1000))
      .isInstanceOf(InvalidInputException.class)
      .hasMessage(ErrorMessage.PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE);
  }

}