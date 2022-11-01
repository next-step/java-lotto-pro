package lotto.conotroller;

import lotto.domain.AutoNumberGenerator;
import lotto.domain.LottoLottery;
import lotto.domain.LottoPurchaseAmount;
import lotto.domain.LottoPurchaseQuantity;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningRanks;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Lotto {
    public void run() {
        Money money = new Money(InputView.inputPurchaseAmount());
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(money.parseAmount());
        LottoPurchaseQuantity lottoPurchaseQuantity = LottoPurchaseQuantity.of(lottoPurchaseAmount.calculateQuantity());
        OutputView.println(lottoPurchaseQuantity.getMessage());

        LottoLottery lottoLottery = lottoPurchaseAmount.toLottoLottery(new AutoNumberGenerator());
        OutputView.println(lottoLottery.lotteryHistory());

        WinningNumbers winningNumbers = WinningNumbers.of(InputView.inputLastWeeksWinningNumber(), InputView.inputBonusNumber());
        WinningRanks winningRanks = lottoLottery.matchWinningRank(winningNumbers);
        OutputView.printStatistics(winningRanks.statistics());
        OutputView.printEarningRatio(winningRanks.calculateEarningRatio(lottoPurchaseAmount));
    }
}
