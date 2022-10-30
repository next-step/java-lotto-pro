package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.util.Constants;

public class TicketList {
    List<Ticket> ticketList;

    public TicketList() {
        ticketList = new ArrayList<>();
    }

    public void addTicket(Ticket t) {
        this.ticketList.add(t);
    }

    public int size() {
        return this.ticketList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Ticket t : ticketList) {
            sb.append(t.toString());
        }

        return sb.toString();
    }

    public Result countTicketResult(Result result, Ticket winningTicket) {
        for (Ticket t : this.ticketList) {
            result.setResult(t.compareTicket(winningTicket));
        }

        return result;
    }
}
