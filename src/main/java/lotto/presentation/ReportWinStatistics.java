package lotto.presentation;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.winpolicy.WinPolicy;
import lotto.domain.winstatistics.WinStatistics;
import lotto.domain.winstatistics.WinStatisticsInfo;
import lotto.infrastructure.component.Label;
import lotto.infrastructure.datashared.UiSharedData;

public class ReportWinStatistics extends Screen {
  Label title;
  Label division;

  Label threeMatchWin;
  Label fourMatchWin;
  Label fiveMatchWin;
  Label fiveAndBonusMatchWin;
  Label sixMatchWin;

  Label revenueRatio;
  WinStatistics winStatistics;

  public ReportWinStatistics() {
    setTopMargin(1);

    winStatistics = new WinStatistics();

    title = new Label();
    division = new Label();

    threeMatchWin = new Label();
    fourMatchWin = new Label();
    fiveMatchWin = new Label();
    fiveAndBonusMatchWin = new Label();
    sixMatchWin = new Label();

    revenueRatio = new Label("");

    initialize();
  }

  @Override
  public void initialize() {
    title.setPrintText("당첨 통계");
    division.setPrintText("---------");
  }

  @Override
  public void render() {
    super.render();

    title.render();
    division.render();

    threeMatchWin.render();
    fourMatchWin.render();
    fiveMatchWin.render();
    fiveAndBonusMatchWin.render();
    sixMatchWin.render();

    revenueRatio.render();
  }

  @Override
  public void update() {
    Lotto latestWinLotto = UiSharedData.getLatestWinLotto();
    Lottos buyLottos = UiSharedData.getBuyLottos();
    LottoNumber bonusNumber = UiSharedData.getBonusNumber();

    winStatistics.analysis(latestWinLotto, buyLottos, bonusNumber);

    threeMatchWin.setPrintText(getStatisticsText(WinPolicy.THREE_MATCH.getMatchCount() + "개 일치", winStatistics.find(WinPolicy.THREE_MATCH)));
    fourMatchWin.setPrintText(getStatisticsText(WinPolicy.FOUR_MATCH.getMatchCount() + "개 일치", winStatistics.find(WinPolicy.FOUR_MATCH)));
    fiveMatchWin.setPrintText(getStatisticsText(WinPolicy.FIVE_MATCH.getMatchCount() + "개 일치", winStatistics.find(WinPolicy.FIVE_MATCH)));
    fiveAndBonusMatchWin.setPrintText(getStatisticsText(WinPolicy.FIVE_BONUS_MATCH.getMatchCount() + "개 일치, 보너스 볼 일치", winStatistics.find(WinPolicy.FIVE_BONUS_MATCH)));    
    sixMatchWin.setPrintText(getStatisticsText(WinPolicy.SIX_MATCH.getMatchCount() + "개 일치", winStatistics.find(WinPolicy.SIX_MATCH)));

    revenueRatio.setPrintText(getRevenueRatioValueText());
  }

  private String getRevenueRatioValueText() {
    if (Float.valueOf(winStatistics.getRevenueRatioValue()) >= 1) {
      return "총 수익률은 " + winStatistics.getRevenueRatioValue();
    }

    return "총 수익률은 " + winStatistics.getRevenueRatioValue() + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  }

  private String getStatisticsText(String matchInformText, WinStatisticsInfo winStatisticsInfo) {
    return String.format("%s (%d원)- %d개", matchInformText, winStatisticsInfo.getWinPrice(), winStatisticsInfo.getCount());
  }

}
