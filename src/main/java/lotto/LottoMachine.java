package lotto;

import lotto.model.LottoBuyer;
import lotto.model.LottoDrawer;
import lotto.model.MatchResults;

public class LottoMachine {
  private final LottoDrawer lottoDrawer;
  private final LottoBuyer lottoBuyer;

  public LottoMachine(LottoDrawer lottoDrawer, LottoBuyer lottoBuyer) {
    this.lottoDrawer = lottoDrawer;
    this.lottoBuyer = lottoBuyer;
  }

  public void execute() {
    MatchResults matchResults = lottoBuyer.matchWithWinningLotto(lottoDrawer.getLotto());
    matchResults.statistics(lottoBuyer.getPurchaseAmount());
  }
}
