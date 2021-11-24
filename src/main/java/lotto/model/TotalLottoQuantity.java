package lotto.model;

import lotto.exception.InvalidInputException;

import static lotto.constants.ErrorMessage.*;

public class TotalLottoQuantity {
  private static final int MIN_MANUAL_LOTTO_QUANTITY = 0;
  private final LottoQuantity autoLottoQuantity;
  private final LottoQuantity manualLottoQuantity;

  private TotalLottoQuantity(LottoQuantity autoLottoQuantity, LottoQuantity manualLottoQuantity) {
    this.autoLottoQuantity = autoLottoQuantity;
    this.manualLottoQuantity = manualLottoQuantity;
  }

  public static TotalLottoQuantity of(PurchaseAmount purchaseAmount, int manualLottoQuantity) {
    int totalLottoQuantity = purchaseAmount.countOfPurchaseLotto();
    int autoLottoQuantity = totalLottoQuantity - manualLottoQuantity;

    checkManualLottoQuantity(totalLottoQuantity, manualLottoQuantity);

    return new TotalLottoQuantity(LottoQuantity.of(autoLottoQuantity), LottoQuantity.of(manualLottoQuantity));
  }

  private static void checkManualLottoQuantity(int totalLottoQuantity, int manualLottoQuantity) {
    if (manualLottoQuantity < MIN_MANUAL_LOTTO_QUANTITY) {
      throw new InvalidInputException(MANUAL_LOTTO_QUANTITY_LOWER_ERROR_MESSAGE);
    }

    if (manualLottoQuantity > totalLottoQuantity) {
      throw new InvalidInputException(MANUAL_LOTTO_QUANTITY_OVER_ERROR_MESSAGE);
    }
  }

  public LottoQuantity toAutoQuantity() {
    return autoLottoQuantity;
  }

  public LottoQuantity toManualQuantity() {
    return manualLottoQuantity;
  }

}