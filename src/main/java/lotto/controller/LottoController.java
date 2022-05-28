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
        AutoNumber autoNumber = new AutoNumber(money.autoCount(manualNumber));
        LottoTickets autoTickets = lottoStore.buyAuto(autoNumber.getAutoNumber());
        LottoTickets purchasedTickets = new LottoTickets(manualTickets, autoTickets);
        OutputView.printLottoAutoTickets(purchasedTickets);

        LottoWinningTicket lottoWinningTicket = InputView.inputWinningTicket();
        LottoRanks lottoRanks = lottoWinningTicket.analyzeResult(purchasedTickets);
        OutputView.printLottoResult(lottoRanks);
        OutputView.printRateOfReturn(money, lottoRanks);
    }
}
