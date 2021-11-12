package lotto;

import lotto.domain.LottoCount;
import lotto.domain.LottoMoney;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.exception.LottoException;
import lotto.factory.LottoTicketFactory;
import view.InputView;
import view.ResultView;

public class LottoMachine {
    public void start() {
        LottoMoney lottoMoney = getLottoMoney();

        LottoCount lottoCount = lottoMoney.calculateLottoCount();
        ResultView.printNumberOfPurchasedLotto(lottoCount.getCount());

        LottoTickets lottoTickets = LottoTicketFactory.createRandomLottoTickets(lottoCount);
        ResultView.printLottoTickets(lottoTickets);
        ResultView.printWinningStatistics(lottoTickets.calculateResult(getWinnerTicket()));
    }

    private LottoMoney getLottoMoney() {
        ResultView.printAskPurchaseAmount();
        try {
            return new LottoMoney(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getLottoMoney();
        }
    }

    private LottoTicket getWinnerTicket() {
        ResultView.printAskWinnerTicket();
        try {
            return new LottoTicket(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.printErrorMessage(lottoException);
            return getWinnerTicket();
        }
    }
}
