package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.Rank;
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
        Map<Rank, Integer> map = winningLotto(totalLotto);
        OutputView.printLottoStatistic(map);
        double profit = calculatorProfit(map, amount);
        OutputView.printProfit(profit);
    }

    private int inputAmount() {
        int amount = new InputView().printRequestAmount();
        return amount;
    }

    private Map<Rank, Integer> winningLotto(TotalLotto totalLotto) throws IOException {
        String inputWinning = new InputView().printRequestWinningLotto();
        Lotto winningLotto = LottoFactory.manualGenerator(inputWinning);
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
