package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoResult;
import java.util.List;
import view.InputView;
import view.ResultView;

public class LottoController {
    public void purchase() {
        int money = InputView.inputMoney();
        List<Lotto> lottos = LottoMachine.issueLottos(money);
        ResultView.printLottos(lottos);

        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        LottoResult lottoResult = LottoResult.of(lottos, winningNumbers);
        ResultView.printLottoResult(lottoResult);
    }
}
