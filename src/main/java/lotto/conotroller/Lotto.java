package lotto.conotroller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Optional;

public class Lotto {
    public void run() {
        LottoPurchaseAmount lottoPurchaseAmount = InputView.inputPurchaseAmount();
        LottoLotteryQuantity lottoLotteryQuantity = InputView.inputManualPurchaseQuantity(lottoPurchaseAmount);

        LottoLottery lottoLottery = getLottoLottery(lottoLotteryQuantity);

        OutputView.printNewLine();
        OutputView.println(lottoLotteryQuantity.history());
        OutputView.println(lottoLottery.lotteryHistory());

        WinningRanks winningRanks = getWinningRanks(lottoLottery);
        OutputView.printStatistics(winningRanks.statistics());
        OutputView.printEarningRatio(winningRanks.calculateEarningRatio(lottoPurchaseAmount));
    }

    private static LottoLottery getLottoLottery(LottoLotteryQuantity lottoLotteryQuantity) {
        Optional<LottoLottery> manualLottery = InputView.inputManualNumbersInformation(lottoLotteryQuantity);
        LottoLottery autoLottery = lottoLotteryQuantity.toAutoLottoLottery();
        manualLottery.ifPresent(lottery -> lottery.addLottery(autoLottery));
        return manualLottery.orElse(autoLottery);
    }

    private static WinningRanks getWinningRanks(LottoLottery lottoLottery) {
        WinningNumbers winningNumbers = new WinningNumbers(InputView.inputLastWeeksWinningNumber(), InputView.inputBonusNumber());
        return lottoLottery.matchWinningRank(winningNumbers);
    }
}
