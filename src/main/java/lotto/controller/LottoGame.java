package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        purchase();
    }

    private void purchase() {
        try {
            Money purchaseMoney = inputView.inputPurchaseMoney();
            LottoSeller lottoSeller = LottoSeller.from(purchaseMoney);
            LottoTickets lottoTickets = lottoSeller.autoLottoTickets();
            outputView.printLottoTickets(lottoTickets);

            winningResult(purchaseMoney, lottoTickets);
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            purchase();
        }
    }

    private void winningResult(Money purchaseMoney, LottoTickets lottoTickets) {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            LottoWinningRanks lottoWinningRanks = lottoTickets.match(LottoTicket.from(winningNumbers));
            outputView.printWinningRanks(lottoWinningRanks, purchaseMoney);
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            winningResult(purchaseMoney, lottoTickets);
        }
    }
}
