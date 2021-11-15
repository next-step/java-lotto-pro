package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tickets {
    private final List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Tickets combineTickets(Tickets... allTickets) {
        List<Ticket> combinedTickets = new ArrayList<>();
        for (Tickets tickets : allTickets) {
            combinedTickets.addAll(tickets.tickets);
        }

        return new Tickets(combinedTickets);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Tickets)) {
            return false;
        }
        Tickets that = (Tickets)o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }
}
