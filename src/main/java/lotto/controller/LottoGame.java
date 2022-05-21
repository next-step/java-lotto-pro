package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public void start() {
        Money money = inputMoney();
        int maxQuantity = money.findPurchaseTicketQuantity();
        TicketQuantity manualQuantity = inputManualQuantity(maxQuantity);
        LottoTickets lottoTickets = buyLottoTickets(money, manualQuantity);
        ResultView.printPurchaseTicketQuantity(manualQuantity.getTicketQuantity(), maxQuantity - manualQuantity.getTicketQuantity());
        ResultView.printLottoTickets(lottoTickets);

        winningResult(lottoTickets, money);
    }

    private Money inputMoney() {
        String input = InputView.inputMoneyView();
        try {
            return new Money(input);
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputMoney();
        }
    }

    private TicketQuantity inputManualQuantity(int maxQuantity) {
        String input = InputView.inputManualQuantityView();
        try {
            return new TicketQuantity(input, maxQuantity);
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputManualQuantity(maxQuantity);
        }
    }

    private LottoTickets buyLottoTickets(Money money, TicketQuantity manualQuantity) {
        LottoMachine lottoMachine = new LottoMachine();
        if (manualQuantity.isEmpty()) {
            LottoTickets manualTickets = inputManualTickets(manualQuantity);
            return lottoMachine.buyLottoTicketWithManual(money, manualTickets);
        }
        return lottoMachine.buyLottoTicket(money);
    }

    private LottoTickets inputManualTickets(TicketQuantity manualQuantity) {
        InputView.printInputManualTicketView();
        try {
            return createManualLottoTickets(manualQuantity);
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputManualTickets(manualQuantity);
        }
    }

    private LottoTickets createManualLottoTickets(TicketQuantity manualQuantity) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < manualQuantity.getTicketQuantity(); i++) {
            lottoTicketList.add(new LottoTicket(InputView.inputNextLine()));
        }
        return new LottoTickets(lottoTicketList, manualQuantity.getTicketQuantity());
    }

    private LottoTicket inputWinningNumbers() {
        String input = InputView.inputWinningNumbersView();
        try {
            return new LottoTicket(input);
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private LottoNumber inputBonusNumber(LottoTicket winningNumbers) {
        String input = InputView.inputBonusNumberView();
        try {
            LottoNumber bonusNumber = new LottoNumber(input);
            winningNumbers.validateUniqueBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputBonusNumber(winningNumbers);
        }
    }

    private void winningResult(LottoTickets lottoTickets, Money purchaseMoney) {
        LottoTicket winningNumbers = inputWinningNumbers();
        LottoNumber bonusNumber = inputBonusNumber(winningNumbers);
        WinningResult winningResult = lottoTickets.match(winningNumbers, bonusNumber);
        ResultView.printWinningReport(winningResult, purchaseMoney);
    }
}
