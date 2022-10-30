package step3.controller;

import step3.domain.amount.Amount;
import step3.domain.input.Input;
import step3.domain.input.InputAmount;
import step3.domain.input.InputWinningLottoNumbers;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.WinningLottoNumbers;
import step3.domain.statistics.LottoStatistics;

import static step3.domain.input.Input.scanner;
import static step3.view.InputView.printInputAmount;
import static step3.view.InputView.printInputWinningLottoNumber;
import static step3.view.ResultView.*;

public class LottoController {

    public void run() {
        printInputAmount();
        Lottos lottos = getLottos();

        printLottoSize(lottos.getLottos());
        printLotto(lottos);
        printInputWinningLottoNumber();

        LottoStatistics lottoStatistics = getLottoStatistics(lottos);
        printResult(lottoStatistics.getLottoResult());
        printTotalProfit(lottoStatistics.getTotalProfit());
    }

    private LottoStatistics getLottoStatistics(Lottos lottos) {
        Input<WinningLottoNumbers> inputWinningLottoNumbers = new InputWinningLottoNumbers();
        WinningLottoNumbers winningLottoNumbers = inputWinningLottoNumbers.create(scanner.nextLine());
        return new LottoStatistics(lottos, winningLottoNumbers);
    }

    private Lottos getLottos() {
        Input<Amount> inputAmount = new InputAmount();
        Amount amount = inputAmount.create(scanner.nextLine());
        return new Lottos(amount);
    }
}
