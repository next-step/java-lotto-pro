package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<LottoTicket> tickets;

    public LottoTickets() {
        this.tickets = new ArrayList<>();
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = new ArrayList<>(tickets);
    }

    public List<LottoTicket> getTicketList() {
        return new ArrayList<>(this.tickets);
    }

    public LottoTickets(LottoTickets autoTickets, LottoTickets selfTickets) {
        this.tickets = Stream.concat(selfTickets.getTicketList().stream()
                , autoTickets.getTicketList().stream()).collect(Collectors.toList());
    }

    public int count() {
        return this.tickets.size();
    }
}
