package lotto.controller;

import lotto.domain.number.Payment;
import lotto.domain.result.Result;
import lotto.domain.ticket.LottoNumbers;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.TicketGenerator;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Payment payment = inputView.inputPayment();
        List<Ticket> tickets = TicketGenerator.generateTickets(payment.numberOfAvailableTickets());
        resultView.outputTickets(TicketGenerator.lottoNumbersDtos(tickets));

        LottoNumbers winningNumbers = inputView.inputLottoNumbers();
        Result result = Result.of(tickets, winningNumbers);
        resultView.outputStatistics(result, payment);
    }
}
