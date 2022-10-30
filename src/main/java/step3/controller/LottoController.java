package step3.controller;

import step3.model.lotto.Lotto;
import step3.model.lotto.Tickets;
import step3.model.machine.Money;
import step3.model.machine.Results;
import step3.model.machine.TicketGenerator;
import step3.model.machine.TicketMachine;
import step3.model.value.Rule;
import step3.view.InputView;
import step3.view.OutputView;

public class LottoController {

    private final TicketMachine ticketMachine;

    public LottoController(TicketGenerator ticketGenerator) {
        this.ticketMachine = new TicketMachine(ticketGenerator);
    }

    public void start(){
        Money money = getMoneyInput();
        int ticketCount = money.availableTicketCount(Rule.TICKET_PRICE);
        Tickets tickets = ticketMachine.issueTickets(ticketCount);
        Lotto lotto = getLottoInput();
        Results results = tickets.getResults(lotto);
        results.printResults();
        results.evaluateResult(ticketCount, results.getWinningPrize());
    }

    private Lotto getLottoInput() {
        String lottoInput = InputView.requestInputLotto();
        return new Lotto(lottoInput);
    }

    private Money getMoneyInput() {
        String moneyInput = InputView.requestInputMoney();
        OutputView.printMoneyInput(moneyInput);
        return new Money(moneyInput);
    }


}
