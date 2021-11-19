package lotto.model;

import lotto.constants.Lotto;
import lotto.exception.InvalidInputException;

import static lotto.constants.ErrorMessage.PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE;

public class PurchaseAmount {
  private final int purchaseAmount;

  public PurchaseAmount(int purchaseAmount) {
    checkPurchaseAmount(purchaseAmount);
    this.purchaseAmount = purchaseAmount;
  }

  private void checkPurchaseAmount(int purchaseAmount) {
    if (purchaseAmount < Lotto.LOTTO_PRICE) {
      throw new InvalidInputException(PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE);
    }
  }

  public LottoQuantity countOfPurchaseLotto() {
    return new LottoQuantity(purchaseAmount / Lotto.LOTTO_PRICE);
  }

  public int getPurchaseAmount() {
    return purchaseAmount;
  }

}