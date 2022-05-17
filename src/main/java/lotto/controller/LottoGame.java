package lotto.controller;

import lotto.constants.ErrorMessage;
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
            LottoCount lottoCount = lottoCount(purchaseMoney);
            LottoTickets inputManualTickets = manualTickets(LottoTickets.empty(), lottoCount);
            LottoTickets lottoTickets = buyLottoTickets(lottoCount, inputManualTickets);

            winningResult(purchaseMoney, lottoTickets);
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            purchase();
        }
    }

    private LottoCount lottoCount(Money purchaseMoney) {
        LottoCount lottoCount;
        try {
            ManualCount manualCount = ManualCount.from(inputView.inputManualCount());
            lottoCount = purchaseMoney.askCount(manualCount);
            return lottoCount;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            lottoCount = lottoCount(purchaseMoney);
        }
        return lottoCount;
    }

    private LottoTickets manualTickets(LottoTickets lottoTickets, LottoCount lottoCount) {
        try {
            outputView.printInputManualNumbers();
            while (lottoCount.isRemainingCount(lottoTickets.size())) {
                lottoTickets.addTicket(inputManualTicket());
            }
            return lottoTickets;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
        }
        return lottoTickets;
    }

    private LottoTicket inputManualTicket() {
        LottoTicket lottoTicket;
        try {
            lottoTicket = LottoTicket.from(inputView.inputManualNumbers());
            return lottoTicket;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            lottoTicket = inputManualTicket();
        }
        return lottoTicket;
    }

    private LottoTickets buyLottoTickets(LottoCount lottoCount, LottoTickets inputManualTickets) {
        LottoTickets lottoTickets = LottoSeller.create().lottoTickets(lottoCount, inputManualTickets);
        outputView.printPurchaseCount(lottoCount);
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private void winningResult(Money purchaseMoney, LottoTickets lottoTickets) {
        try {
            List<Integer> winningNumbers = inputView.inputWinningNumbers();
            LottoTicket winningLotto = LottoTicket.from(winningNumbers);
            LottoNumber bonusBall = bonusBall(winningLotto);
            LottoWinningRanks lottoWinningRanks = lottoTickets.match(LottoTicket.from(winningNumbers), bonusBall);
            outputView.printWinningRanks(lottoWinningRanks, purchaseMoney);
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            winningResult(purchaseMoney, lottoTickets);
        }
    }

    private LottoNumber bonusBall(LottoTicket winningLotto) {
        LottoNumber bonusBall;
        try {
            bonusBall = inputView.inputBonusBall();
            winningLotto.duplicateBonusBall(bonusBall);
            return bonusBall;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            bonusBall = bonusBall(winningLotto);
        }

        if (bonusBall == null) {
            throw new IllegalArgumentException(ErrorMessage.UNKNOWN_ERROR);
        }
        return bonusBall;
    }
}
