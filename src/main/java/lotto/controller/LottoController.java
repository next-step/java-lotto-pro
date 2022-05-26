package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore();

        Money money = new Money(InputView.inputMoney());
        ManualNumber manualNumber = InputView.inputManualNumber(money);
        List<LottoTicket> manualTickets = InputView.inputManualTickets(manualNumber);
        List<LottoTicket> autoTickets = lottoStore.buy(money);
        OutputView.printLottoAutoTickets(autoTickets);

        LottoWinningTicket lottoWinningTicket = InputView.inputWinningTicket();
        LottoRanks lottoRanks = lottoWinningTicket.analyzeResult(autoTickets);
        OutputView.printLottoResult(lottoRanks);
        OutputView.printRateOfReturn(money, lottoRanks);
    }
}
