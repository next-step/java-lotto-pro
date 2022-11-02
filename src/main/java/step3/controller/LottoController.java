package step3.controller;

import step3.domain.amount.Amount;
import step3.domain.lotto.*;
import step3.domain.statistics.LottoStatistics;

import static step3.view.InputView.*;
import static step3.view.ResultView.*;

public class LottoController {

    public void run() {
        Lottos lottos = new Lottos(new Amount(inputAmount()));

        printLottosQuantity(lottos.value().size());
        printLottos(lottos.toString());

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(inputWinningLottoNumber());
        BonusLottoNumber bonusLottoNumber = new BonusLottoNumber(LottoNumber.of(inputBonusLottoNumber()));

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winningLottoNumbers, bonusLottoNumber));

        printResult(lottoStatistics.toString());
        printTotalProfit(lottoStatistics.getTotalProfit());
    }
}
