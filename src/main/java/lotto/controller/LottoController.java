package lotto.controller;


import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore();
        List<LottoTicket> lottoAutoNumbers = lottoStore.buy(new Money(InputView.inputMoney()));
        OutputView.printLottoAutoTickets(lottoAutoNumbers);

        LottoWinningTicket lottoWinningNumbers = InputView.inputWinningNumbers();
        LottoRanks lottoRanks = lottoWinningNumbers.analyzeResult(lottoAutoNumbers);
        OutputView.printLottoResult(lottoRanks);
    }
}
