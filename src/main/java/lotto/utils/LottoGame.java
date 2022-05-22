package lotto.utils;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoGame {
    public void start() {
        int amount = InputView.printRequestAmount();
        TotalLotto totalLotto = TotalLotto.from(amount);
        OutputView.printQuantity(totalLotto);

        Map<Rank, Integer> map = calculatorLottoScore(totalLotto);
        OutputView.printLottoStatistic(map);
        double profit = calculatorProfit(map, amount);
        OutputView.printProfit(profit);
    }

    private Map<Rank, Integer> calculatorLottoScore(TotalLotto totalLotto) {
        Lotto lotto = LottoFactory.manualGenerator(InputView.printRequestWinningLotto());
        LottoNumber lottoNumber = new LottoNumber(InputView.printRequestBonusNumber());
        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);
        Map<Rank, Integer> map = totalLotto.getLottoList().matchLottoStaticToString(winningLotto);
        return map;
    }

    private double calculatorProfit(Map<Rank, Integer> map, int amount) {
        double result = 0;
        for (Map.Entry<Rank, Integer> lottoStatistic : map.entrySet()) {
            result += lottoStatistic.getKey().calculatorProfit(lottoStatistic.getValue());
        }
        return result/amount;
    }
}
