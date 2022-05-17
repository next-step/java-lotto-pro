package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoStatistic;
import lotto.domain.TotalLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.IOException;
import java.util.Map;

public class LottoGame {
    public void start() throws IOException {
        TotalLotto totalLotto = new TotalLotto();
        int amount = inputAmount();
        totalLotto.of(amount);
        OutputView.printQuantity(totalLotto);
        Map<LottoStatistic, Integer> map = winningLotto(totalLotto);
        OutputView.printLottoStatistic(map);
        double profit = calculatorProfit(map, amount);
        OutputView.printProfit(profit);
    }

    private int inputAmount() {
        int amount = new InputView().printRequestAmount();
        Validation.isValidCount(amount);
        return amount;
    }

    private Map<LottoStatistic, Integer> winningLotto(TotalLotto totalLotto) throws IOException {
        String inputWinning = new InputView().printRequestWinningLotto();
        Lotto winningLotto = new Lotto(inputWinning);
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
