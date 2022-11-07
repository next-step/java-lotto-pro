package controller;

import domain.*;

import java.util.List;
import java.util.Set;

import view.InputView;
import view.ResultView;

public class LottoController {
    public void purchase() {
        int money = InputView.inputMoney();
        int countOfSelfPickLotto = InputView.inputCountOfSelfPickLotto();
        List<Set<Integer>> selfPickNumbers = InputView.inputSelfPickNumbers(countOfSelfPickLotto);

        Lottos lottos = LottoMachine.issueLottos(money);
        ResultView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusWinningNumber = InputView.inputBonusWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumbers, bonusWinningNumber);
        LottoResult lottoResult = LottoResult.of(lottos, winningNumber);
        ResultView.printLottoResult(lottoResult);
    }
}
