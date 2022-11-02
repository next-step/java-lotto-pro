package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Result;

public class Tickets {
    private final static String NEWLINE = "\n";
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

    public Result countTicketResult(Result result, Ticket winningTicket) {
        for (Ticket t : this.tickets) {
            int countOfMatch = t.getCountOfMatch(winningTicket.lottoNumbers);
            boolean matchBonus = t.isBonusballMatch(winningTicket.bonusNum);
            result.checkPrizeMoney(countOfMatch, matchBonus);
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Ticket t : tickets) {
            sb.append(t.toString()).append(NEWLINE);
        }

        return sb.toString();
    }
}
