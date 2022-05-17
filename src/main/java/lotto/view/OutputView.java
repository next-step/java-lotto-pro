package lotto.view;

import lotto.constants.DisplayMessage;
import lotto.domain.*;

public class OutputView {
    public void printPurchaseCount(LottoCount lottoCount) {
        System.out.printf(DisplayMessage.PURCHASE_LOTTO_COUNT, lottoCount.manualCount(), lottoCount.autoCount());
    }

    public void printInputManualNumbers() {
        System.out.printf(DisplayMessage.INPUT_MANUAL_NUMBERS);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
    }

    public void printWinningRanks(LottoWinningRanks lottoWinningRanks, Money purchaseMoney) {
        System.out.printf(DisplayMessage.WINNING_STATISTICS);
        System.out.println(DisplayMessage.DIVIDE_LINE);
        System.out.println(lottoWinningRanks);
        System.out.printf(DisplayMessage.RETURN_RATE, lottoWinningRanks.returnRate(purchaseMoney));
        System.out.printf(DisplayMessage.RETURN_RATE_DESCRIPTION, lottoWinningRanks.resultDescription(purchaseMoney));
    }

    public void printExceptionMessage(Exception e) {
        System.out.printf(e.getMessage());
    }
}
