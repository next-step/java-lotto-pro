package lotto.model;

import calculator.ErrorMessage;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static lotto.constants.ErrorMessage.MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE;
import static lotto.constants.ErrorMessage.MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TotalLottoQuantityTest {
  @Test
  void 자동_및_수동_로또_수량을_가진다() {
    TotalLottoQuantity totalLottoQuantity = TotalLottoQuantity.of(new PurchaseAmount(14000), 14);

    assertThat(totalLottoQuantity.toAutoQuantity()).isEqualTo(new LottoQuantity(0));
    assertThat(totalLottoQuantity.toManualQuantity()).isEqualTo(new LottoQuantity(14));
  }

  @Test
  void 구매한_로또_개수_보다_수동_로또_개수가_클_경우_예외() {
    assertThatThrownBy(() -> TotalLottoQuantity.of(new PurchaseAmount(10000), 11))
      .isInstanceOf(InvalidInputException.class)
      .hasMessage(MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE);
  }

  @Test
  void 입력한_수동_로또_개수가_음수일_경우_예외() {
    assertThatThrownBy(() -> TotalLottoQuantity.of(new PurchaseAmount(10000), -1))
      .isInstanceOf(InvalidInputException.class)
      .hasMessage(MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
  }

}