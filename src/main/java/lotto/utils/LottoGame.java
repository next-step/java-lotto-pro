package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoStatistic;
import lotto.domain.TotalLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;
import java.util.Map;

public class LottoGame {
    public void start() throws IOException {
        int amount = inputAmount();
        TotalLotto totalLotto = TotalLotto.from(amount);
        OutputView.printQuantity(totalLotto);
        Map<LottoStatistic, Integer> map = winningLotto(totalLotto);
        OutputView.printLottoStatistic(map);
        double profit = calculatorProfit(map, amount);
        OutputView.printProfit(profit);
    }

    private int inputAmount() {
        int amount = new InputView().printRequestAmount();
        return amount;
    }

    private Map<LottoStatistic, Integer> winningLotto(TotalLotto totalLotto) throws IOException {
        String inputWinning = new InputView().printRequestWinningLotto();
        Lotto winningLotto = LottoFactory.manualGenerator(inputWinning);
        Map<LottoStatistic, Integer> map = totalLotto.getLottoList().matchLottoStaticToString(winningLotto);
        return map;
    }

    private double calculatorProfit(Map<LottoStatistic, Integer> map, int amount) {
        double result = 0;
        for (Map.Entry<LottoStatistic, Integer> lottoStatistic : map.entrySet()) {
            result += lottoStatistic.getKey().calculatorProfit(lottoStatistic.getValue());
        }
        return result/amount;
    }
}
