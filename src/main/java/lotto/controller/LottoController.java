package lotto.controller;

import java.util.List;

import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningResult;
import lotto.domain.WinningResults;
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
        lottos.execute(LottoNumbers.valueOf(inputView.enterWinningLotto()));
        WinningResults results = new WinningResults(lottos);
        resultView.printWinningResults(results);
        resultView.printWinningRewardPercent(this.calculateRewardPercent(results, money));

    }

    private double calculateRewardPercent(WinningResults results, Money money) {
        List<WinningResult> resultList = results.getWinningResult();
        int totalReward = 0;
        for (WinningResult result : resultList) {
            totalReward += result.getCount() * result.getWinningRank().getReward();
        }

        return totalReward / (double) money.getMoney();
    }

}
