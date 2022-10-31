package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.PayAmount;
import lotto.util.ProfitCalculator;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {

    private final PayAmount payAmount;
    private final Lottos lottos;

    public LottoGame(int inputPayAmount) {
        payAmount = new PayAmount(inputPayAmount);
        printLottoAmount();
        lottos = new Lottos(payAmount.lottoAmount());
        printLottos();
    }

    private void printLottoAmount() {
        OutputView.printLottoAmount(payAmount.lottoAmount());
    }

    private void printLottos() {
        for (Lotto lotto : lottos.getLottos()) {
            OutputView.printLottos(lotto);
        }
    }

    public void checkLottoNumbers(List<Integer> winningNumbers) {
        LottoResult lottoResult = lottos.findWinner(new Lotto(winningNumbers));
        double profitRatio = ProfitCalculator.calculateProfit(lottoResult, lottos.getLottos().size());
        printLottoResult(lottoResult, profitRatio);
    }

    private void printLottoResult(LottoResult lottoResult, double profitRatio) {
        OutputView.printLottoResult(lottoResult, profitRatio);
    }
}