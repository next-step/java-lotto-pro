package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoGame {

    public void start() {
        Money money = inputMoney();
        LottoMachine lottoMachine = new LottoMachine();
        LottoTickets lottoTickets = lottoMachine.buyLottoTicket(money);
        ResultView.printPurchaseTicketQuantity(lottoTickets.size());
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
        String input = InputView.inputBonusNumber();
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
