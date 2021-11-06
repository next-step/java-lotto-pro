package lotto.controller;

import java.util.*;

import lotto.domain.number.*;
import lotto.domain.result.*;
import lotto.domain.ticket.*;
import lotto.view.*;

public class LottoController {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Payment payment = Payment.from(inputView.inputPayment());
        List<Ticket> tickets = TicketGenerator.generateTickets(payment.numberOfAvailableTickets());
        resultView.outputTickets(TicketGenerator.lottoNumbersDtos(tickets));

        LottoNumbers lottoNumbers = LottoNumbers.from(inputView.inputLottoNumbers());
        WinningNumbers winningNumbers = WinningNumbers.of(lottoNumbers, inputView.inputBonusNumber());
        Result result = Result.of(tickets, winningNumbers);
        resultView.outputStatistics(result, payment);
    }
}
