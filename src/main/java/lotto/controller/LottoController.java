package lotto.controller;


import lotto.domain.LottoStore;
import lotto.domain.LottoTicket;
import lotto.domain.LottoWinningTicket;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    public void startSales() {
        LottoStore lottoStore = new LottoStore();
        List<LottoTicket> lottoAutoNumbers = lottoStore.buy(new Money(InputView.inputMoney()));
        OutputView.printLottoAutoTickets(lottoAutoNumbers);

        LottoWinningTicket lottoWinningNumbers = InputView.inputWinningNumbers();
//        LottoTicket winningLottoTicket = new LottoTicket(InputView.inputWinningNumbers());
//        OutputView.printLottoResult(winningLottoTicket, lottoAutoNumbers);
    }
}
