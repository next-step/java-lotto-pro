package lotto;

import lotto.controller.LottoGame;
import lotto.controller.LottoMoney;
import lotto.controller.LottoNumberGenerator;
import lotto.model.LottoPaper;
import lotto.model.LottoPapers;
import lotto.model.LottoResult;
import lotto.util.Client;
import lotto.util.GameRule;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {

    public static void main(String[] args) {

        LottoGame lottoGame = new LottoGame();
        LottoMoney lottoMoney = new LottoMoney();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        LottoApplication lottoApplication = new LottoApplication();

        String buyPrice = lottoApplication.getBuyPrice();
        LottoPapers lottoPapers = lottoApplication.getRandomLottoPapers(buyPrice, lottoMoney);

        LottoPaper winningLottoPaper = lottoApplication.getWinningLottoPaper(lottoNumberGenerator);
        lottoApplication.printLottoResult(lottoGame, lottoPapers, winningLottoPaper);
    }

    private String getBuyPrice() {
        InputView.printBuyPriceInput();
        return Client.getLineConsole();
    }

    private LottoPaper getWinningLottoPaper(LottoNumberGenerator lottoNumberGenerator) {

        InputView.printWinningNumberInput();
        String winningNumber = Client.getLineConsole();
        return lottoNumberGenerator.createWinningNumber(winningNumber);
    }

    private LottoPapers getRandomLottoPapers(String buyPrice, LottoMoney lottoMoney) {

        long lottoPaperCount = lottoMoney.getLottoPaperCount(lottoMoney.parseIntBuyPrice(buyPrice));
        ResultView.printBuyCountOutput(lottoPaperCount);
        LottoPapers lottoPapers = LottoPapers.createLottoPapers(lottoPaperCount);
        ResultView.printLottoPapers(lottoPapers);

        return lottoPapers;
    }

    private void printLottoResult(LottoGame lottoGame, LottoPapers lottoPapers, LottoPaper winningLottoPaper) {

        LottoResult lottoResult = lottoGame.getLottoResult(lottoPapers, winningLottoPaper);
        lottoResult.calculateYield(lottoPapers.lottoPaperSize() * GameRule.LOTTO_PAPER_PRICE);
        ResultView.printWinningStatistics(lottoResult);
    }
}
