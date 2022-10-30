package step3.model.machine;

import java.util.ArrayList;
import java.util.List;
import step3.model.lotto.Ticket;
import step3.model.lotto.Tickets;
import step3.model.value.Rule;
import step3.view.OutputView;

public class TicketMachine {
    private final TicketGenerator ticketGenerator;
    public TicketMachine(TicketGenerator ticketGenerator) {
        this.ticketGenerator = ticketGenerator;
    }

    public Tickets issueTickets(int ticketCount) {
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Ticket(ticketGenerator.generateTicket(Rule.LOTTO_NUMBER_LENGTH)));
        }
        OutputView.printTicketCount(ticketCount);
        return new Tickets(tickets);
    }
}
