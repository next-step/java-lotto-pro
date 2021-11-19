package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.exception.NumberOutOfRangeException;

public class ManualLottoQuantity {
  private static final int MINIMUM_QUANTITY = 0;
  private final int manualLottoQuantity;

  public ManualLottoQuantity(int manualLottoQuantity) {
    checkManualLottoQuantity(manualLottoQuantity);

    this.manualLottoQuantity = manualLottoQuantity;
  }

  private void checkManualLottoQuantity(int manualLottoQuantity) {
    if (manualLottoQuantity < MINIMUM_QUANTITY) {
      throw new NumberOutOfRangeException(ErrorMessage.MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }
  }

  public int gapWith(int lottoQuantity) {
    return Math.abs(manualLottoQuantity - lottoQuantity);
  }
}
