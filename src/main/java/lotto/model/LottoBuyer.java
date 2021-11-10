package lotto.model;

import lotto.generator.LottoGenerator;

import java.util.Objects;


public class LottoBuyer {
  private final PurchaseAmount purchaseAmount;
  private final LottoTicket lottoTicket;


  private LottoBuyer(PurchaseAmount purchaseAmount, LottoTicket lottoTicket) {
    this.purchaseAmount = purchaseAmount;
    this.lottoTicket = lottoTicket;
  }

  public static LottoBuyer buy(PurchaseAmount purchaseAmount, LottoGenerator lottoGenerator) {
    LottoTicket lottoTicket = new LottoTicket(purchaseAmount.buyLottos(lottoGenerator));
    return new LottoBuyer(purchaseAmount, lottoTicket);
  }

  public MatchResults matchWithWinningLotto(LottoNumbers winningLottoNumbers) {
    return lottoTicket.totalWinningResults(winningLottoNumbers);
  }

  public int buyCount() {
    return purchaseAmount.buyLottoCount();
  }

  public LottoTicket getLottoTicket() {
    return lottoTicket;
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
