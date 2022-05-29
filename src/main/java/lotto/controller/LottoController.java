package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore();

        Money money = InputView.inputMoney();
        ManualLottoTicketCount manualTicketCount = InputView.inputManualNumber(money);
        LottoTickets manualTickets = InputView.inputManualTickets(manualTicketCount);
        LottoTickets autoTickets = lottoStore.buyAuto(money.autoCount(manualTicketCount));
        LottoTickets purchasedTickets = new LottoTickets(manualTickets, autoTickets);
        OutputView.printLottoAutoTickets(purchasedTickets);

        LottoWinningTicket lottoWinningTicket = InputView.inputWinningTicket();
        LottoRanks lottoRanks = lottoWinningTicket.analyzeResult(purchasedTickets);
        OutputView.printLottoResult(lottoRanks);
        OutputView.printRateOfReturn(money, lottoRanks);
    }
}
