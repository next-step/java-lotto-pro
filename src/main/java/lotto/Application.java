package lotto;

import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.getInstance();
        long money = InputView.inputMoney();

        List<Lotto> lottoes = lottoController.buyLotto(money);
        ResultView.printLottoNumber(lottoes);

        Lotto winner = new Lotto(InputView.inputAnswer());
        LottoNumber bonusNumber = LottoNumber.ofString(InputView.inputBonusAnswer());
        long totalPrize = lottoController.exchangePrize(lottoes, new WinningNumbers(winner, bonusNumber));
        lottoController.printYield(totalPrize, money);
    }
}

