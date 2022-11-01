package lotto.domain;

import java.util.stream.IntStream;

public class Lotto {
    private static final String STR_BUY_LOTTO = "%d개를 구매했습니다.\n";
    private static final int TICKET_VALUE = 1000;
    
    public Tickets tickets;

    public Lotto(String moneyStr) {
        buyLotto(new Money(moneyStr));
    }

    public Lotto(Tickets myTickets) {
        this.tickets = myTickets;
    }

    public String getTicketsSizeStr() {
        return String.format(STR_BUY_LOTTO, this.tickets.size());
    }

    public String getLottoListStr() {
        return this.tickets.toString();
    }

    public String getResultStr(String winningTicketStr, String bonusNumStr) {
        Result result = new Result();

        this.tickets.countTicketResult(result, new Ticket(winningTicketStr, bonusNumStr));

        int usedMoney = this.tickets.size() * TICKET_VALUE;
        return result.toString(usedMoney);
    }

    private void buyLotto(Money money) {
        int buyCount = money.amount / TICKET_VALUE;
        tickets = new Tickets();

        IntStream.rangeClosed(1, buyCount).forEach(i -> {
            tickets.addTicket(new Ticket());
        });
    }
}
