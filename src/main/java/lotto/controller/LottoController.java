package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.lotto.domain.LottoGenerator;
import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.MatchCount;
import lotto.winning.domain.TotalWinningMoney;
import lotto.winning.domain.WinningNumber;

import static lotto.lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.winning.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.winning.ui.outputView.WinningResultOutputVeiw.winningResult;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        LottoGenerator lottoGenerator = new LottoGenerator(lottoMoney.purchaseCount());
        printLottos(lottoGenerator.generateLottos());
        System.out.println();
        TotalWinningMoney totalWinningMoney = createTotalWinningMoney(lottoGenerator);
        winningResult(totalWinningMoney, lottoMoney);
    }

    private TotalWinningMoney createTotalWinningMoney(LottoGenerator lottoGenerator) {
        WinningNumber winningNumber = createWinningNumber();
        MatchCount matchCount = new MatchCount(lottoGenerator.generateLottos(), winningNumber);
        return new TotalWinningMoney(matchCount.matchCount(3), matchCount.matchCount(4), matchCount.matchCount(5), matchCount.matchCount(6));
    }

    private static WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
