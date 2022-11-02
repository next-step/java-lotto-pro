package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    public LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public Rewards check(LottoTicket winningTicket) {
        return this.ticketList.stream()
                .map(LottoTicket -> Rank.valueOf(LottoTicket.compareTicket(winningTicket)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public int getTicketCount() {
        return this.ticketList.size();
    }
}
