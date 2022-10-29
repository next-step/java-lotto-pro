package lotto.conotroller;

import lotto.domain.AutoNumberGenerator;
import lotto.domain.LottoLottery;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoPurchaseQuantity;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningRanks;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(InputView.inputPurchaseAmount());
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        OutputView.println(lottoPurchaseQuantity.getMessage());

        LottoLottery lottoLottery = LottoLottery.of(lottoPurchaseQuantity, new AutoNumberGenerator());
        OutputView.println(lottoLottery.lotteryHistory());

        WinningNumbers winningNumbers = WinningNumbers.of(InputView.inputLastWeeksWinningNumber());
        WinningRanks winningRanks = lottoLottery.checkWinningRank(winningNumbers);
        OutputView.printStatistics(winningRanks.statistics());
        OutputView.printEarningRatio(winningRanks.calculateEarningRatio(lottoPurchaseAmount));
    }
}
