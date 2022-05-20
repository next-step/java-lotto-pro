package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        long money = InputView.inputMoney();
        int lottoController.buyLotto(money);
        ResultView.printLottoNumber(lottoes);

        Lotto answer = new Lotto(InputView.inputAnswer());
        long totalPrize = lottoController.exchangePrize(lottoes, answer);
        lottoController.printYield(totalPrize, money);
    }
}

