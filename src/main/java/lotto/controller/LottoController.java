package lotto.controller;

import calculator.Delimiters;
import calculator.TextExtractor;
import lotto.lotto.domain.LottoGenerator;
import lotto.lotto.domain.LottoPurchaseAmount;
import lotto.lotto.domain.Lottos;
import lotto.winning.domain.ReturnRate;
import lotto.winning.domain.TotalWinningMoneyCalculator;
import lotto.winning.domain.WinningMoneyCalculator;
import lotto.winning.domain.WinningNumber;
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
        List<Lottos> lottoses = lottoGenerator.generateLottoses();
        printLottos(lottoGenerator.generateLottoses());
        System.out.println();
        Delimiters delimiters = new Delimiters();
        TextExtractor extractor = new TextExtractor(readWinningNumbers());
        WinningNumber winningNumber = new WinningNumber(extractor.extract().split(delimiters.delimiter()));
        List<Lottos> threeMatches = new ArrayList<>();
        List<Lottos> fourMatches = new ArrayList<>();
        List<Lottos> fiveMatches = new ArrayList<>();
        List<Lottos> sixMatches = new ArrayList<>();
        for (Lottos lottos : lottoses) {
            if (winningNumber.matchCounts(lottos) == 3) {
                threeMatches.add(lottos);
            } else if (winningNumber.matchCounts(lottos) == 4) {
                fourMatches.add(lottos);
            } else if (winningNumber.matchCounts(lottos) == 5) {
                fiveMatches.add(lottos);
            } else if (winningNumber.matchCounts(lottos) == 6) {
                sixMatches.add(lottos);
            }
        }
        List<WinningMoneyCalculator> calculators = new ArrayList<>();
        calculators.add(new WinningMoneyCalculator(3, threeMatches.size()));
        calculators.add(new WinningMoneyCalculator(4, fourMatches.size()));
        calculators.add(new WinningMoneyCalculator(5, fiveMatches.size()));
        calculators.add(new WinningMoneyCalculator(6, sixMatches.size()));
        TotalWinningMoneyCalculator totalWinningMoneyCalculator = new TotalWinningMoneyCalculator(calculators);
        WinningResultOutputVeiw.winningMoney(totalWinningMoneyCalculator);
        WinningResultOutputVeiw.returnRate(new ReturnRate(lottoPurchaseAmount, totalWinningMoneyCalculator));

    }
}
