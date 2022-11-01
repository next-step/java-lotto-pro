package step3.controller;

import step3.domain.lotto.BonusLottoNumber;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.WinningLotto;
import step3.domain.lotto.WinningLottoNumbers;
import step3.domain.statistics.LottoStatistics;

import static step3.view.InputView.*;
import static step3.view.ResultView.*;

public class LottoController {

    public void run() {
        Lottos lottos = inputAmount();

        printLottosQuantity(lottos);
        printLottos(lottos);

        WinningLottoNumbers winningLottoNumbers = inputWinningLottoNumber();
        BonusLottoNumber bonusLottoNumber = inputBonusLottoNumber();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, new WinningLotto(winningLottoNumbers, bonusLottoNumber));

        printResult(lottoStatistics);
        printTotalProfit(lottoStatistics);
    }
}
