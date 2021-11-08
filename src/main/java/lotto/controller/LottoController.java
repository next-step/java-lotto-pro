package lotto.controller;

import lotto.domain.number.*;
import lotto.domain.result.*;
import lotto.domain.ticket.*;
import lotto.view.*;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Payment payment = Payment.from(inputView.inputPayment());
        ManualTicketsCount manualTicketsCount = ManualTicketsCount.from(inputView.inputManualTicketCount());
        Tickets tickets = Tickets.of(payment, inputView.inputLottoNumbersAsManyTimesOf(manualTicketsCount.number()));
        resultView.outputTickets(manualTicketsCount.number(), TicketGenerator.lottoNumbersDtos(tickets.tickets()));

        LottoNumbers lottoNumbers = LottoNumbers.from(InputView.inputWinningNumbers());
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, inputView.inputBonusNumber());
        Result result = Result.of(tickets.tickets(), winningNumbers);
        resultView.outputStatistics(result, payment);
    }
}
