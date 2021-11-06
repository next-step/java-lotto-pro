package lotto;

import lotto.model.*;
import lotto.util.Client;
import lotto.util.GameRule;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        String buyPrice = LottoApplication.getBuyPrice();
        LottoMoney lottoMoney = new LottoMoney(buyPrice);
        LottoPapers lottoPapers = LottoApplication.getRandomLottoPapers(lottoMoney);

        LottoPaper winningLottoPaper = LottoApplication.getWinningLottoPaper(lottoNumberGenerator);
        LottoNumber bonusNumber = LottoApplication.getBonusNumber(winningLottoPaper);
        LottoApplication.printLottoResult(lottoPapers, winningLottoPaper, bonusNumber);
    }

    private static String getBuyPrice() {
        InputView.printBuyPriceInput();
        return Client.getLineConsole();
    }

    private static LottoPaper getWinningLottoPaper(LottoNumberGenerator lottoNumberGenerator) {
        InputView.printWinningNumberInput();
        String winningNumber = Client.getLineConsole();
        return lottoNumberGenerator.createWinningNumber(winningNumber);
    }

    private static LottoPapers getRandomLottoPapers(LottoMoney lottoMoney) {
        long lottoPaperCount = lottoMoney.getLottoPaperCount();
        ResultView.printBuyCountOutput(lottoPaperCount);
        LottoPapers lottoPapers = LottoPapers.createLottoPapers(lottoPaperCount);
        ResultView.printLottoPapers(lottoPapers);
        return lottoPapers;
    }

    private static void printLottoResult(LottoPapers lottoPapers, LottoPaper winningLottoPaper, LottoNumber bonusNumber) {
        LottoResult lottoResult = lottoPapers.calculateLottoResult(winningLottoPaper, bonusNumber);
        lottoResult.calculateYield(lottoPapers.lottoPaperSize() * GameRule.LOTTO_PAPER_PRICE);
        ResultView.printWinningStatistics(lottoResult);
    }

    private static LottoNumber getBonusNumber(LottoPaper winningLottoPaper) {
        InputView.printBonusNumberInput();
        String bonusNumber = Client.getLineConsole();
        return new LottoNumber(bonusNumber, winningLottoPaper);
    }
}
