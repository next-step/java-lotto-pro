package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.constants.Lotto;
import lotto.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

import static lotto.constants.ErrorMessage.INPUT_EMPTY_ERROR_MESSAGE;

public class PurchaseAmount {
  private final int purchaseAmount;

  private PurchaseAmount(int purchaseAmount) {
    this.purchaseAmount = purchaseAmount;
  }

  public static PurchaseAmount valueOf(int purchaseAmount) {
    checkPurchaseAmount(purchaseAmount);

    return new PurchaseAmount(purchaseAmount);
  }

  private static void checkPurchaseAmount(int purchaseAmount) {
    checkLowerThanLottoPrice(purchaseAmount);
  }

  private static void checkLowerThanLottoPrice(int purchaseAmount) {
    if (purchaseAmount < Lotto.LOTTO_PRICE) {
      throw new RuntimeException(ErrorMessage.PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE);
    }
  }

  public LottoTicket buyLottoTicket(LottoGenerator lottoGenerator) {
    int lottoCount = buyLottoCount();
    List<LottoNumbers> lottoList = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottoList.add(lottoGenerator.generate());
    }

    return new LottoTicket(lottoList);
  }

  public int buyLottoCount() {
    return purchaseAmount / Lotto.LOTTO_PRICE;
  }

  public double calculateYield(long sum) {
    return sum / (purchaseAmount * 1.0);
  }
}
