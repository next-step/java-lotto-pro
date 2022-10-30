package lotto.domain;

import java.util.stream.IntStream;
import lotto.util.Constants;

public class Lotto {
    public TicketList ticketList;

    public Lotto(String input) {
        buyLotto(new Input(input));
    }

    public Lotto(TicketList myTickets) {
        this.ticketList = myTickets;
    }

    public String getTicketListSizeStr() {
        return String.format(Constants.STR_BUY_LOTTO, this.ticketList.size());
    }

    public String getLottoListStr() {
        return this.ticketList.toString();
    }

    public String getResultStr(String winningTicketStr) {
        Result result = new Result();

        this.ticketList.countTicketResult(result, new Ticket(winningTicketStr));

        int usedMoney = this.ticketList.size() * Constants.TICKET_VALUE;
        return result.toString(usedMoney);
    }

    private void buyLotto(Input input) {
        int buyCount = input.amount / Constants.TICKET_VALUE;
        ticketList = new TicketList();

        IntStream.range(Constants.ZERO, buyCount).forEach(i -> {
            ticketList.addTicket(new Ticket());
        });
    }
}
