package lotto.domain.ticket;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.*;
import lotto.exception.*;

public class Tickets {
    private final List<Ticket> tickets;

    private Tickets(Payment payment, List<List<Integer>> manualTickets) {
        validate(manualTickets);
        this.tickets = manualTickets.stream()
            .map(Ticket::from)
            .collect(Collectors.toList());

        this.tickets
            .addAll(TicketGenerator.generateTickets(
                    payment.numberOfAvailableTicketsAutomatically(manualTickets.size())
                )
            );
    }

    public static Tickets of(Payment payment, List<List<Integer>> manualTickets) {
        return new Tickets(payment, manualTickets);
    }

    private void validate(List<List<Integer>> manualTickets) {
        if (Objects.isNull(manualTickets)) {
            throw new NullArgumentException(this.getClass().getSimpleName());
        }
    }

    public List<Ticket> tickets() {
        return tickets;
    }
}
