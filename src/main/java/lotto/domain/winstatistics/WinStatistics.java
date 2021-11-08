package lotto.domain.winstatistics;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.winpolicy.WinPolicy;

public class WinStatistics {
  private RevenueRatio revenueRatio;
  private WinStatisticsInfos winStatisticsInfos;

  public WinStatistics() {
    winStatisticsInfos = new WinStatisticsInfos();
  }

  public WinStatisticsInfo find(WinPolicy winPolicy) {
    return this.winStatisticsInfos.findBy(winPolicy);
  }

  public String getRevenueRatioValue() {
    return revenueRatio.getValue();
  }

  public void analysis(Lotto latestWinLotto, Lottos buyLottos, LottoNumber bonusNumber) {
    Integer totalWinPrice = 0;

    this.winStatisticsInfos.clear();

    for (WinPolicy winPolicy : WinPolicy.values()) {
      Integer matchCount = winPolicy.getMatchCount(latestWinLotto, buyLottos, bonusNumber);

      this.winStatisticsInfos.add(WinStatisticsInfo.of(winPolicy, matchCount));

      totalWinPrice += matchCount * winPolicy.getWinPrice();
    }

    this.revenueRatio = RevenueRatio.of(totalWinPrice, buyLottos.getPrice());
  }
}
