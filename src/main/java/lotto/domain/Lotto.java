package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;

public class Lotto {
    private static final int TICKET_VALUE = 1000;
    private Tickets tickets;
    
    public Lotto() {
        this.tickets = new Tickets();
    }

    public Lotto(Tickets myTickets) {
        this.tickets = myTickets;
    }
    
    public Tickets buyTickets(Money money) {
        int buyCount = money.amount / TICKET_VALUE;

        IntStream.rangeClosed(1, buyCount).forEach(i -> {
            this.tickets.addTicket(new Ticket());
        });
        
        return this.tickets;
    }
    
    public Money getUsedMoney() {
        return new Money(this.tickets.size() * TICKET_VALUE);
    }
}
