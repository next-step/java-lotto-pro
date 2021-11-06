package lotto.model;

import lotto.generator.LottoGenerator;
import lotto.view.OutputView;

import java.util.Objects;

import static lotto.view.OutputView.printBuyCount;

public class LottoBuyer {
  private final PurchaseAmount purchaseAmount;
  private final Lottos lottos;


  private LottoBuyer(PurchaseAmount purchaseAmount, Lottos lottos) {
    this.purchaseAmount = purchaseAmount;
    this.lottos = lottos;
  }

  public static LottoBuyer buy(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
    printBuyCount(purchaseAmount);
    Lottos lottos = new Lottos(purchaseAmount.buyLottos(lottoGenerator));

    OutputView.printGeneratedLottos(lottos);
    return new LottoBuyer(purchaseAmount, lottos);
  }

  public MatchResults matchWithWinningLotto(Lotto winningLotto) {
    return lottos.totalWinningResults(winningLotto);
  }

  public int buyCount() {
    return purchaseAmount.buyLottoCount();
  }

  public PurchaseAmount getPurchaseAmount() {
    return purchaseAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoBuyer user = (LottoBuyer) o;
    return Objects.equals(purchaseAmount, user.purchaseAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(purchaseAmount);
  }
}
