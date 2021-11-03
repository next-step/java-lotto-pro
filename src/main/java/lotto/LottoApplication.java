package lotto;

import lotto.controller.LottoGame;
import lotto.model.LottoPaper;
import lotto.model.LottoPaperList;
import lotto.model.LottoResult;
import lotto.util.Client;
import lotto.util.GameRule;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        InputView.printBuyPriceInput();
        String buyPrice = Client.getLineConsole();

        long lottoPaperCount = LottoGame.getLottoPaperCount(LottoGame.parseIntBuyPrice(buyPrice));
        ResultView.printBuyCountOutput(lottoPaperCount);
        LottoPaperList lottoPaperList = LottoGame.getLottoPaperList(lottoPaperCount);
        ResultView.printLottoPaperList(lottoPaperList);

        InputView.printWinningNumberInput();
        String winningNumber = Client.getLineConsole();

        LottoPaper winningLottoPaper = LottoGame.getWinningNumber(winningNumber);
        LottoResult lottoResult = LottoGame.getLottoResult(lottoPaperList, winningLottoPaper);
        lottoResult.calculateYield(lottoPaperCount * GameRule.LOTTO_PAPER_PRICE);
        ResultView.printWinningStatistics(lottoResult);

    }
}
