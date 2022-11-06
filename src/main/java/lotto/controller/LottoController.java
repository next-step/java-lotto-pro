package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.*;

import static lotto.ui.inputView.LottoMoneyInputView.readPurchaseMoney;
import static lotto.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.outputView.StatisticsOutputView.winningResult;

public class LottoController {

    public void run() {
        Lottos lottos = new LottoGenerator(new LottoMoney(readPurchaseMoney())).generate();
        printLottos(lottos);
        winningResult(new Statistics(lottos, new WinningNumber(new TextExtractor(new Delimiters(), readWinningNumbers()).extract())));
    }
}
