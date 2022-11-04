package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.lotto.domain.Lotto;
import lotto.lotto.domain.LottoGenerator;
import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.MatchingCount;
import lotto.winning.domain.TotalWinningMoney;
import lotto.winning.domain.WinningNumber;

import java.util.List;

import static lotto.lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.winning.ui.inputView.WinningNumberInputView.readWinningNumbers;
import static lotto.winning.ui.outputView.WinningResultOutputVeiw.winningResult;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        LottoGenerator lottoGenerator = new LottoGenerator(lottoMoney.purchaseCount());
        List<Lotto> lottos = lottoGenerator.generateLottos();
        printLottos(lottos);
        System.out.println();
        TotalWinningMoney totalWinningMoney = createTotalWinningMoney(lottos);
        winningResult(totalWinningMoney, lottoMoney);
    }

    private TotalWinningMoney createTotalWinningMoney(List<Lotto> lottos) {
        WinningNumber winningNumber = createWinningNumber();
        return new TotalWinningMoney(new MatchingCount(lottos, winningNumber));
    }

    private static WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
