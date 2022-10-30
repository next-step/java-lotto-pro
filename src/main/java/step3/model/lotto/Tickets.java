package step3.model.lotto;

import java.util.List;
import java.util.Objects;
import step3.model.machine.Results;
import step3.view.OutputView;

public class Tickets {

    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
        printTickets();
    }

    private void printTickets() {
        tickets.stream().forEach(ticket -> OutputView.printTicket(ticket));
    }

    public Results getResults(Lotto lotto) {
        Results results = new Results();
        tickets.stream().forEach(ticket -> results.recordResult(ticket.getResult(lotto)));
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tickets)) {
            return false;
        }
        Tickets tickets1 = (Tickets) o;
        return Objects.equals(tickets, tickets1.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
