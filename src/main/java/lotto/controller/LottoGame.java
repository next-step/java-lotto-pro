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

    private LottoNumbers inputWinningNumbers() {
        String input = InputView.inputWinningNumbersView();
        try {
            return new LottoNumbers(input);
        } catch (IllegalArgumentException e) {
            ResultView.printInputErrorMessage(e);
            return inputWinningNumbers();
        }
    }

    private void winningResult(LottoTickets lottoTickets, Money purchaseMoney) {
        LottoNumbers winningNumbers = inputWinningNumbers();
        WinningResult winningResult = lottoTickets.match(winningNumbers);
        ResultView.printWinningReport(winningResult, purchaseMoney);
    }
}
