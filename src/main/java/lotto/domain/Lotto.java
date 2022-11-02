package lotto.domain;

import java.util.stream.IntStream;
import lotto.domain.ticket.Ticket;
import lotto.domain.ticket.Tickets;

public class Lotto {
    private static final int TICKET_VALUE = 1000;
    
    public Tickets tickets;
    public Result result;

    public Lotto(String money) {
        buyLotto(new Money(money));
    }

    public Lotto(Tickets myTickets) {
        this.tickets = myTickets;
    }

    public void checkResult(Ticket winningTicket) {
        this.result = new Result();
        this.tickets.countTicketResult(result, winningTicket);
        
        int usedMoney = this.tickets.size() * TICKET_VALUE;
        result.checkResultRate(usedMoney);
    }

    private void buyLotto(Money money) {
        int buyCount = money.amount / TICKET_VALUE;
        tickets = new Tickets();

        IntStream.rangeClosed(1, buyCount).forEach(i -> {
            tickets.addTicket(new Ticket());
        });
    }
}
