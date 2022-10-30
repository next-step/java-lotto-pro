package lotto.domain;

import java.util.stream.IntStream;
import lotto.util.Constants;

public class Lotto {
    public TicketList ticketList;
    
    private static int ONE = 1;
    
    public Lotto(String input) {
        buyLotto(new Input(input));
    }
    
    public Lotto(TicketList myTickets) {
        this.ticketList = myTickets;
    }
    
    public String getLottoListStr() {
        return this.ticketList.toString();
    }
    
    public String getResultStr(String winningTicketStr) {
        Result result = new Result();
        
        this.ticketList.countTicketResult(result, new Ticket(winningTicketStr));
        return result.toString(this.ticketList.size() * Constants.TICKET_VALUE);
    }
    
    private void buyLotto(Input input) {
        int buyCount = input.amount / Constants.TICKET_VALUE;
        ticketList = new TicketList();
        
        IntStream.rangeClosed(ONE, buyCount).forEach(i -> {
            ticketList.addTicket(new Ticket());
        });
    }
}
