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

        LottoPapersGenerator lottoPapersGenerator = new LottoPapersGenerator(lottoMoney, lottoNumberGenerator);

        LottoPapers manualLottoPapers = lottoPapersGenerator.getManualLottoPapers(getManualLottoBuyCount(lottoMoney));
        LottoPapers lottoPapers = lottoPapersGenerator.getRandomLottoPapers();

        LottoApplication.printLottoBuyCount(lottoMoney);

        lottoPapers = lottoPapers.addLottoPapers(manualLottoPapers);
        LottoApplication.printLottoPapers(lottoPapers);

        LottoPaper winningLottoPaper = LottoApplication.getWinningLottoPaper(lottoNumberGenerator);
        LottoNumber bonusLottoNumber = LottoApplication.getBonusNumber();

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

    private static LottoNumber getBonusNumber() {
        InputView.printBonusNumberInput();
        String bonusNumber = Client.getLineConsole();
        return new LottoNumber(bonusNumber);
    }

    private static int getManualLottoBuyCount(LottoMoney lottoMoney) {

        InputView.printManualLottoBuyCountInput();
        int manualLottoBuyCount = lottoMoney.parseManualLottoPaperCount(Client.getLineConsole());

        InputView.printManualLottoNumberInput();

        return manualLottoBuyCount;
    }

}
