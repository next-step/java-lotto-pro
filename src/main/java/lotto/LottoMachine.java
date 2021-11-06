package lotto;

import view.InputView;
import view.OutputMessage;
import view.ResultView;

public class LottoMachine {
    public void start() {
        LottoMoney lottoMoney = getLottoMoney();

        LottoCount lottoCount = lottoMoney.calculateLottoCount();
        ResultView.print(() -> String.format(OutputMessage.PRINT_NUMBER_OF_PURCHASED_LOTTO.makePrintableMessage(),
            lottoCount.makePrintableMessage()));

        LottoTickets lottoTickets = LottoTicketFactory.createRandomLottoTickets(lottoCount);
        ResultView.print(lottoTickets);
        printWinningStatistics(lottoTickets.calculateResult(getWinnerTicket()));
    }

    private LottoMoney getLottoMoney() {
        ResultView.print(OutputMessage.ASK_PURCHASE_AMOUNT);
        try {
            return new LottoMoney(InputView.readLine());
        } catch (LottoException lottoException) {
            ResultView.print(lottoException::getMessage);
            return getLottoMoney();
        }
    }

    private LottoTicket getWinnerTicket() {
        ResultView.print(OutputMessage.PRINT_NEW_LINE);
        ResultView.print(OutputMessage.ASK_WINNER_TICKET);
        return new LottoTicket(InputView.readLine());
    }

    private void printWinningStatistics(LottoResults lottoResults) {
        ResultView.print(OutputMessage.PRINT_NEW_LINE);
        ResultView.print(OutputMessage.PRINT_STATISTICS_INTRO);
        ResultView.print(lottoResults);
        ResultView.print(() -> String.format(OutputMessage.PRINT_TOTAL_EARNING_RATE.makePrintableMessage(),
            lottoResults.calculateEarningRate().makePrintableMessage()));
    }
}
