package lotto.view;

import lotto.constants.DisplayMessage;
import lotto.domain.LottoTickets;
import lotto.domain.LottoWinningRanks;
import lotto.domain.Money;

public class OutputView {
    public void printLottoTickets(LottoTickets lottoTickets) {
        System.out.printf(DisplayMessage.PURCHASE_LOTTO_COUNT, lottoTickets.size());
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
        System.out.println(e.getMessage());
    }
}
