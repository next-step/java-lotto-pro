package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.lotto.domain.LottoGenerator;
import lotto.lotto.domain.LottoPurchaseAmount;
import lotto.winning.domain.*;
import lotto.winning.ui.outputView.WinningResultOutputVeiw;

import java.util.ArrayList;
import java.util.List;

import static lotto.lotto.ui.inputView.LottoPurchaseInputView.readPurchaseMoney;
import static lotto.lotto.ui.outputView.GeneratedLottosOutputView.printLottos;
import static lotto.winning.ui.inputView.WinningNumberInputView.readWinningNumbers;

public class LottoController {

    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(readPurchaseMoney());
        int purchaseCount = lottoPurchaseAmount.purchaseCount();
        LottoGenerator lottoGenerator = new LottoGenerator(purchaseCount);
        printLottos(lottoGenerator.generateLottos());
        System.out.println();
        List<WinningMoneyCalculator> calculators = createCalculators(lottoGenerator);
        TotalWinningMoneyCalculator totalWinningMoneyCalculator = new TotalWinningMoneyCalculator(calculators);
        WinningResultOutputVeiw.winningMoney(totalWinningMoneyCalculator);
        WinningResultOutputVeiw.returnRate(new ReturnRate(lottoPurchaseAmount, totalWinningMoneyCalculator));
    }

    private static List<WinningMoneyCalculator> createCalculators(LottoGenerator lottoGenerator) {
        WinningNumber winningNumber = createWinningNumber();
        WinningCount winningCount = new WinningCount(lottoGenerator.generateLottos(), winningNumber);
        winningCount.generate();
        List<WinningMoneyCalculator> calculators = new ArrayList<>();
        calculators.add(new WinningMoneyCalculator(3, winningCount.getThreeMatchCount()));
        calculators.add(new WinningMoneyCalculator(4, winningCount.getFourMatchCount()));
        calculators.add(new WinningMoneyCalculator(5, winningCount.getFiveMatchCount()));
        calculators.add(new WinningMoneyCalculator(6, winningCount.getSixMatchCount()));
        return calculators;
    }

    private static WinningNumber createWinningNumber() {
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        return new WinningNumber(extractor.extract().split(delimiters.delimiter()));
    }
}
