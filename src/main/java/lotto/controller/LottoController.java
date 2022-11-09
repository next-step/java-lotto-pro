package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.*;
import lotto.domain.Number;

import static lotto.ui.inputView.BonusBallInputView.readBonusBall;
import static lotto.ui.inputView.LottoMoneyInputView.readPurchaseMoney;
import static lotto.ui.inputView.WinningLottoInputView.readWinningLotto;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.outputView.StatisticsOutputView.winningResult;

public class LottoController {

    public void run() {
        Lottos lottos = new LottoGenerator().generate(new LottoMoney(readPurchaseMoney()).purchaseCount());
        printLottos(lottos);
        winningResult(lottos, new WinningLotto(winningLottos(), new Number(readBonusBall())));
    }

    private static String[] winningLottos() {
        return new TextExtractor(new Delimiters(), readWinningLotto()).extract();
    }
}
