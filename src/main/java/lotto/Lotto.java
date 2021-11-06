package lotto;

import view.InputView;
import view.OutputMessage;
import view.ResultView;

public class Lotto {
    public void start() {
        ResultView.print(OutputMessage.ASK_PURCHASE_AMOUNT::getMessage);
        LottoMoney lottoMoney = new LottoMoney(InputView.readLine());
        LottoCount lottoCount = lottoMoney.calculateLottoCount();
        ResultView.print(() ->
            lottoCount.makePrintableMessage() + OutputMessage.PRINT_NUMBER_OF_PURCHASED_LOTTO.getMessage());

        LottoTickets lottoTickets = LottoTicketFactory.createRandomLottoTickets(lottoCount);
        ResultView.print(lottoTickets);

        LottoTicket winnerTicket = new LottoTicket(InputView.readLine());
        LottoResults lottoResults = lottoTickets.calculateResult(winnerTicket);
        ResultView.print(OutputMessage.PRINT_STATISTICS_INTRO::getMessage);
        ResultView.print(lottoResults);
        ResultView.print(() -> String.format(OutputMessage.PRINT_TOTAL_EARNING_RATE.getMessage(), lottoResults.calculateEarningRate().makePrintableMessage()));
    }
}
