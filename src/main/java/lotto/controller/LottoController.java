package lotto.controller;

import java.util.List;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningStatistic;
import lotto.domain.WinningStatistics;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final ResultView resultView = new ResultView();

    public void start() {
        Money money = inputView.enterMoney();
        resultView.printBuyMessage(money.buyableQuantity());
        Lottos lottos = new Lottos(money.buyableQuantity());
        resultView.printLottoList(lottos);
        lottos.countWinningRank(inputView.enterWinningLotto());
        WinningStatistics statistics = new WinningStatistics(lottos);
        resultView.printWinningStatistics(statistics);
        resultView.printWinningRewardPercent(this.calculateRewardPercent(statistics, money));

    }
    
    private double calculateRewardPercent(WinningStatistics statistics, Money money) {
        List<WinningStatistic> statisticList = statistics.getWinningStatistic();
        int totalReward = 0;
        for (WinningStatistic statistic : statisticList) {
            totalReward += statistic.getCount() * statistic.getWinningRank().getReward();
        }
        
        return totalReward/(double)money.getMoney();
    }

}
