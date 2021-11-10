package lotto.model;

import lotto.constants.ErrorMessage;
import lotto.constants.Lotto;
import lotto.generator.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class PurchaseAmount {
  private final int purchaseAmount;
  public PurchaseAmount(int purchaseAmount) {
    checkPurchaseAmount(purchaseAmount);

    this.purchaseAmount = purchaseAmount;
  }

  private void checkPurchaseAmount(int purchaseAmount) {
    checkLowerThanLottoPrice(purchaseAmount);
  }

  private void checkLowerThanLottoPrice(int purchaseAmount) {
    if (purchaseAmount < Lotto.LOTTO_PRICE) {
      throw new RuntimeException(ErrorMessage.PURCHASE_AMOUNT_LOWER_ERROR_MESSAGE);
    }
  }

  public List<LottoNumbers> buyLottos(LottoGenerator lottoGenerator) {
    int lottoCount = buyLottoCount();
    List<LottoNumbers> lottoTicket = new ArrayList<>();
    for (int i = 0; i < lottoCount; i++) {
      lottoTicket.add(lottoGenerator.generate());
    }

    return lottoTicket;
  }

  public int buyLottoCount() {
    return purchaseAmount / Lotto.LOTTO_PRICE;
  }

  public double calculateYield(long sum) {
    return sum / (purchaseAmount * 1.0);
  }
}
