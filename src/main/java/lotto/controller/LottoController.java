package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.*;

import static lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.outputView.WinningResultOutputView.winningResult;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generate(lottoMoney.purchaseCount());
        printLottos(lottos);
        winningResult(new Statistics(lottos, createWinningNumber()));
    }

    private WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
