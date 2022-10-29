package controller;

import domain.Lotto;
import domain.LottoMachine;
import domain.LottoPurchaser;
import java.util.List;
import view.InputView;

public class LottoController {
    public void purchase() {
        int money = InputView.askInputMoney();
        List<Lotto> lottos = LottoMachine.issueLottos(money);
        InputView.printPurchasedLottos(lottos);

        List<Integer> winningNumber = InputView.askInputWinningNumber();
        LottoPurchaser lottoPurchaser = LottoPurchaser.of(lottos, winningNumber);
        InputView.printLottoResult(lottoPurchaser);
    }
}
