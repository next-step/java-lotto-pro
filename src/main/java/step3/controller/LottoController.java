package step3.controller;

import step3.domain.amount.Amount;
import step3.domain.input.Input;
import step3.domain.input.InputAmount;
import step3.domain.input.InputBonusLottoNumber;
import step3.domain.input.InputWinningLottoNumbers;
import step3.domain.lotto.BonusLottoNumber;
import step3.domain.lotto.Lottos;
import step3.domain.lotto.WinningLottoNumbers;
import step3.domain.statistics.LottoStatistics;

import static step3.domain.input.Input.scanner;
import static step3.view.InputView.*;
import static step3.view.ResultView.*;

public class LottoController {

    public void run() {
        printInputAmount();
        Lottos lottos = getLottos();

        printLottoSize(lottos.getLottos());
        printLotto(lottos);

        printInputWinningLottoNumber();
        WinningLottoNumbers winningLottoNumbers = getWinningLottoNumbers();

        printInputBonusLottoNumber();
        BonusLottoNumber bonusLottoNumber = getBonusLottoNumber();

        LottoStatistics lottoStatistics = new LottoStatistics(lottos, winningLottoNumbers, bonusLottoNumber);

        printResult(lottoStatistics.getLottoResult());
        printTotalProfit(lottoStatistics.getTotalProfit());
    }

    private static BonusLottoNumber getBonusLottoNumber() {
        Input<BonusLottoNumber> inputBonusLottoNumber = new InputBonusLottoNumber();
        return inputBonusLottoNumber.create(scanner.nextLine());
    }

    private static WinningLottoNumbers getWinningLottoNumbers() {
        Input<WinningLottoNumbers> inputWinningLottoNumbers = new InputWinningLottoNumbers();
        return inputWinningLottoNumbers.create(scanner.nextLine());
    }

    private Lottos getLottos() {
        Input<Amount> inputAmount = new InputAmount();
        Amount amount = inputAmount.create(scanner.nextLine());
        return new Lottos(amount);
    }
}
