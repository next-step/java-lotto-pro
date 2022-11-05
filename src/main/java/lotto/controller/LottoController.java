package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoMoney;
import lotto.domain.MatchingCount;
import lotto.domain.TotalWinningMoney;
import lotto.domain.WinningNumber;

import java.util.List;

import static lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.ui.outputView.WinningResultOutputView.winningResult;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = lottoGenerator.generate(lottoMoney.purchaseCount());
        printLottos(lottos);
        System.out.println();
        TotalWinningMoney totalWinningMoney = createTotalWinningMoney(lottos);
        winningResult(totalWinningMoney, lottoMoney);
    }

    private TotalWinningMoney createTotalWinningMoney(List<Lotto> lottos) {
        WinningNumber winningNumber = createWinningNumber();
        return new TotalWinningMoney(new MatchingCount(lottos, winningNumber));
    }

    private WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
