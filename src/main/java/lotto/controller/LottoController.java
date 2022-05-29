package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore();

        Money money = InputView.inputMoney();
        ManualNumber manualNumber = InputView.inputManualNumber(money);
        LottoTickets manualTickets = InputView.inputManualTickets(manualNumber);
        LottoTickets autoTickets = lottoStore.buyAuto(money.autoCount(manualNumber));
        LottoTickets purchasedTickets = new LottoTickets(manualTickets, autoTickets);
        OutputView.printLottoAutoTickets(purchasedTickets);

        LottoWinningTicket lottoWinningTicket = InputView.inputWinningTicket();
        LottoRanks lottoRanks = lottoWinningTicket.analyzeResult(purchasedTickets);
        OutputView.printLottoResult(lottoRanks);
        OutputView.printRateOfReturn(money, lottoRanks);
    }
}
