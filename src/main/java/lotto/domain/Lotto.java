package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;

public class Lotto {
    private static final String ERR_BUY_MORE_THAN_MONEY = "소지금이 부족합니다.";
    private static final int TICKET_VALUE = 1000;
    private Tickets tickets;
    
    public Lotto() {
        this.tickets = new Tickets();
    }

    public Lotto(Tickets myTickets) {
        this.tickets = myTickets;
    }
    
    public int buyAutoTickets(Money money, int manualTicketBuyCount) {
        int autoTicketBuyCount = (int)(money.amount / TICKET_VALUE) - manualTicketBuyCount;
        
        if(autoTicketBuyCount < 0) {
            throw new IllegalArgumentException(ERR_BUY_MORE_THAN_MONEY);
        }

        IntStream.rangeClosed(1, autoTicketBuyCount).forEach(i -> {
            this.tickets.addTicket(new Ticket());
        });
        
        return autoTicketBuyCount;
    }
    
    public void buyManualTicket(String number) {
        Ticket t = new Ticket(number);
        
        this.tickets.addTicket(t);
    }
    
    public Tickets getMyTickets() {
        return this.tickets;
    }
}