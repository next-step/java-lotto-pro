package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.lotto.domain.LottoGenerator;
import lotto.lotto.domain.LottoMoney;
import lotto.winning.domain.*;
import lotto.winning.ui.outputView.WinningResultOutputVeiw;

import java.util.ArrayList;
import java.util.List;

import static lotto.lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.winning.ui.inputView.WinningNumberInputView.readWinningNumbers;

public class LottoController {

    public void run() {
        LottoMoney lottoMoney = new LottoMoney(readPurchaseMoney());
        int purchaseCount = lottoMoney.purchaseCount();
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseCount);
        printLottos(lottoGenerator.generateLottos());
        System.out.println();
        List<WinningMoney> calculators = createCalculators(lottoGenerator);
        TotalWinningMoney totalWinningMoney = new TotalWinningMoney(calculators);
        WinningResultOutputVeiw.winningMoney(totalWinningMoney);
        WinningResultOutputVeiw.returnRate(new ReturnRate(lottoMoney, totalWinningMoney));
    }

    private static List<WinningMoney> createCalculators(LottoGenerator lottoGenerator) {
        WinningNumber winningNumber = createWinningNumber();
        MatchCount matchCount = new MatchCount(lottoGenerator.generateLottos(), winningNumber);
        matchCount.generate();
        List<WinningMoney> calculators = new ArrayList<>();
        calculators.add(new WinningMoney(3, matchCount.getThreeMatchCount()));
        calculators.add(new WinningMoney(4, matchCount.getFourMatchCount()));
        calculators.add(new WinningMoney(5, matchCount.getFiveMatchCount()));
        calculators.add(new WinningMoney(6, matchCount.getSixMatchCount()));
        return calculators;
    }

    private static WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
