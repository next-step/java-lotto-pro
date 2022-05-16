package lotto.controller;

import lotto.constants.ErrorMessage;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
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
            ManualCount manualCount = manualCount(purchaseMoney);
            LottoTickets inputManualTickets = manualTickets(LottoTickets.from(new ArrayList<>()), manualCount);

            LottoTickets lottoTickets = LottoSeller.create().lottoTickets(purchaseMoney, manualCount, inputManualTickets);
            outputView.printPurchaseCount(manualCount, purchaseMoney);
            outputView.printLottoTickets(lottoTickets);

            winningResult(purchaseMoney, lottoTickets);
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            purchase();
        }
    }

    private ManualCount manualCount(Money purchaseMoney) {
        ManualCount manualCount;
        try {
            manualCount = ManualCount.from(inputView.inputManualCount(), purchaseMoney);
            return manualCount;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            manualCount = manualCount(purchaseMoney);
        }

        if (manualCount == null) {
            manualCount = ManualCount.create();
        }
        return manualCount;
    }

    private LottoTickets manualTickets(LottoTickets lottoTickets, ManualCount manualCount) {
        try {
            outputView.printInputManualNumbers();
            while (manualCount.isRemainingCount(lottoTickets.size())) {
                lottoTickets.addTicket(inputManualTicket());
            }
            return lottoTickets;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
        }
        return lottoTickets;
    }

    private LottoTicket inputManualTicket() {
        LottoTicket lottoTicket = null;
        try {
            lottoTicket = LottoTicket.from(inputView.inputManualNumbers());
            return lottoTicket;
        } catch (IllegalArgumentException ie) {
            outputView.printExceptionMessage(ie);
            lottoTicket = inputManualTicket();
        }
        return lottoTicket;
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
        LottoNumber bonusBall = null;
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
