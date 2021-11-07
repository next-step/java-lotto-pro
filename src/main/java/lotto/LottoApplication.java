package lotto;

import lotto.model.*;
import lotto.util.Client;
import lotto.util.GameRule;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        String buyPrice = LottoApplication.getBuyPrice();
        LottoMoney lottoMoney = new LottoMoney(buyPrice);

        LottoPapers manualLottoPapers = LottoApplication.getManualLottoPapers(lottoMoney, lottoNumberGenerator);
        LottoPapers lottoPapers = LottoApplication.getRandomLottoPapers(lottoMoney);

        LottoApplication.printLottoBuyCount(lottoMoney);

        lottoPapers = lottoPapers.addLottoPapers(manualLottoPapers);
        LottoApplication.printLottoPapers(lottoPapers);

        LottoPaper winningLottoPaper = LottoApplication.getWinningLottoPaper(lottoNumberGenerator);
        LottoNumber bonusLottoNumber = LottoApplication.getBonusNumber(winningLottoPaper);

        WinningLotto winningLotto = new WinningLotto(winningLottoPaper, bonusLottoNumber);
        LottoApplication.printLottoResult(lottoPapers, winningLotto);
    }

    private static String getBuyPrice() {
        InputView.printBuyPriceInput();
        return Client.getLineConsole();
    }

    private static LottoPaper getWinningLottoPaper(LottoNumberGenerator lottoNumberGenerator) {
        InputView.printWinningNumberInput();
        String winningNumber = Client.getLineConsole();
        return lottoNumberGenerator.createManualLottoNumber(winningNumber);
    }

    private static LottoPapers getRandomLottoPapers(LottoMoney lottoMoney) {
        int lottoPaperCount = lottoMoney.getLottoPaperCount();
        return LottoPapers.createLottoPapers(lottoPaperCount);
    }

    private static void printLottoBuyCount(LottoMoney lottoMoney) {
        ResultView.printBuyCountOutput(lottoMoney.getManualLottoPaperCount(), lottoMoney.getLottoPaperCount() );
    }
    private static void printLottoPapers(LottoPapers lottoPapers) {
        ResultView.printLottoPapers(lottoPapers);
    }

    private static void printLottoResult(LottoPapers lottoPapers, WinningLotto winningLotto) {
        LottoResult lottoResult = lottoPapers.calculateLottoResult(winningLotto);
        lottoResult.calculateYield(lottoPapers.getLottoPapersSize() * GameRule.LOTTO_PAPER_PRICE);
        ResultView.printWinningStatistics(lottoResult);
    }

    private static LottoNumber getBonusNumber(LottoPaper winningLottoPaper) {
        InputView.printBonusNumberInput();
        String bonusNumber = Client.getLineConsole();
        return new LottoNumber(bonusNumber, winningLottoPaper);
    }

    private static LottoPapers getManualLottoPapers(LottoMoney lottoMoney, LottoNumberGenerator lottoNumberGenerator) {

        List<LottoPaper> manualLottoPapers = new ArrayList<>();
        InputView.printManualLottoBuyCountInput();
        int manualLottoBuyCount = lottoMoney.buyManualLottoPaper(Client.getLineConsole());

        InputView.printManualLottoNumberInput();

        for (int i = 0; i < manualLottoBuyCount; i++) {
            String manualNumber = Client.getLineConsole();
            manualLottoPapers.add(lottoNumberGenerator.createManualLottoNumber(manualNumber));
        }
        return new LottoPapers(manualLottoPapers);
    }
}
