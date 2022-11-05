package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.*;

import java.util.List;

import static lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.ui.outputView.WinningResultOutputView.winningResult;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos lottos = lottoGenerator.generate(lottoMoney.purchaseCount());
        printLottos(lottos);
        System.out.println();
        TotalWinningMoney totalWinningMoney = createTotalWinningMoney(lottos);
        winningResult(totalWinningMoney, lottoMoney);
    }

    private TotalWinningMoney createTotalWinningMoney(Lottos lottos) {
        WinningNumber winningNumber = createWinningNumber();
        return new TotalWinningMoney(new MatchingCount(lottos.getLottos(), winningNumber));
    }

    private WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
