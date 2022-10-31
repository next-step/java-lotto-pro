package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Constants;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket t) {
        this.tickets.add(t);
    }

    public int size() {
        return this.tickets.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Ticket t : tickets) {
            sb.append(t.toString());
        }

        return sb.toString();
    }

    public Result countTicketResult(Result result, Ticket winningTicket) {
        for (Ticket t : this.tickets) {
            result.setResult(t.compareTicket(winningTicket));
        }

        return result;
    }
}
