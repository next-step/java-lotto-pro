package lotto.controller;

import lotto.domain.LottoMarket;
import lotto.domain.LottoTicket;
import lotto.util.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public void run() {
        List<LottoTicket> tickets = LottoMarket.sell(InputView.getMoney(), new RandomLottoGenerator());
        ResultView.printTickets(tickets);
    }
}
