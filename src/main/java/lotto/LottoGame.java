package lotto;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int cost = InputView.inputMoney();
        int manualQuantity = InputView.inputManualQuantity();
        Lottos manualLottos = InputView.inputManualLotto(manualQuantity);
        Lottos autoLottos = lottoMachine.buyAuto(cost, manualQuantity);
        Lottos lottos = manualLottos.add(autoLottos);
        ResultView.printLottos(lottos);

        Lotto winner = InputView.inputWinnerNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();

        List<Result> results = lottos.getResults(winner, bonusNumber);
        ResultView.printResults(results);

        double profit = lottoMachine.calculateProfit(cost, results);
        ResultView.printProfit(profit);
    }

}
