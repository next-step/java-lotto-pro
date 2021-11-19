package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.InvalidInputException;
import lotto.exception.NumberOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoQuantityTest {
  @DisplayName("수동 로또 수량이 로또 총 수량 보다 클 경우 예외를 발생시킨다.")
  @Test
  void 수동_로또_수량과_전체_수량_간_예외_검증() {
    PurchaseAmount purchaseAmount = new PurchaseAmount(14000);
    LottoQuantity lottoQuantity = purchaseAmount.countOfPurchaseLotto();

    assertThatThrownBy(() -> lottoQuantity.ofManualLottoQuantity(15))
      .isInstanceOf(InvalidInputException.class)
      .hasMessage(ErrorMessage.MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE);
  }

  @DisplayName("수동 로또 수량을 -1이하로 입력할 경우 예외를 발생시킨다.")
  @Test
  void 수동_로또_수량_마이너스_예외_검증() {
    assertThatThrownBy(() -> new ManualLottoQuantity(-1))
      .isInstanceOf(NumberOutOfRangeException.class)
      .hasMessage(ErrorMessage.MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
  }

}