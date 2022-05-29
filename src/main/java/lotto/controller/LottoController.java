package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void startSales() {
        Money money = InputView.inputMoney();
        ManualLottoTicketCount manualTicketCount = InputView.inputManualNumber(money);
        LottoTickets manualTickets = InputView.inputManualTickets(manualTicketCount);
        LottoTickets purchasedTickets = LottoStore.buy(money, manualTickets);
        OutputView.printLottoAutoTickets(purchasedTickets, manualTicketCount);

        LottoWinningTicket lottoWinningTicket = InputView.inputWinningTicket();
        LottoRanks lottoRanks = lottoWinningTicket.analyzeResult(purchasedTickets);
        OutputView.printLottoResult(lottoRanks);
        OutputView.printRateOfReturn(money, lottoRanks);
    }
}
