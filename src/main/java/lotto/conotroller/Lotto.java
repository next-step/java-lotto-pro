package lotto.conotroller;

import java.util.Optional;
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
        LottoPurchaseAmount lottoPurchaseAmount = getLottoPurchaseAmount();
        LottoPurchaseQuantity manualQuantity = LottoPurchaseQuantity.manualQuantity(InputView.inputManualPurchaseQuantity());
        LottoPurchaseQuantity autoQuantity = lottoPurchaseAmount.calculateAutoQuantity(manualQuantity);

        LottoLottery lottoLottery = getLottoLottery(manualQuantity, autoQuantity);

        OutputView.printNewLine();
        OutputView.println(LottoPurchaseQuantity.history(manualQuantity, autoQuantity));
        OutputView.println(lottoLottery.lotteryHistory());

        WinningRanks winningRanks = getWinningRanks(lottoLottery);
        OutputView.printStatistics(winningRanks.statistics());
        OutputView.printEarningRatio(winningRanks.calculateEarningRatio(lottoPurchaseAmount));
    }

    private static LottoPurchaseAmount getLottoPurchaseAmount() {
        Money money = new Money(InputView.inputPurchaseAmount());
        return new LottoPurchaseAmount(money.parseAmount());
    }

    private static LottoLottery getLottoLottery(LottoPurchaseQuantity manualQuantity,
                                                LottoPurchaseQuantity autoQuantity) {
        Optional<LottoLottery> manualLottery = manualQuantity.toManualLottoLottery();
        LottoLottery autoLottery = autoQuantity.toAutoLottoLottery();
        manualLottery.ifPresent(lottery -> lottery.addLottery(autoLottery));
        return manualLottery.orElse(autoLottery);
    }

    private static WinningRanks getWinningRanks(LottoLottery lottoLottery) {
        WinningNumbers winningNumbers = WinningNumbers.of(InputView.inputLastWeeksWinningNumber(), InputView.inputBonusNumber());
        return lottoLottery.matchWinningRank(winningNumbers);
    }
}
