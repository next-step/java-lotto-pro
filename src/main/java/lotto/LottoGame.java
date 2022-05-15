package lotto;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoNumber;
import lotto.model.Lottos;
import lotto.model.Result;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int cost = InputView.inputMoney();
        Lottos lottos = lottoMachine.buy(cost);
        ResultView.printLottos(lottos);

        Lotto winner = InputView.inputWinnerNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        List<Result> results = lottos.getResults(winner, bonusNumber);
        ResultView.printResults(results);

        double profit = lottoMachine.calculateProfit(cost, results);
        ResultView.printProfit(profit);
    }

}
