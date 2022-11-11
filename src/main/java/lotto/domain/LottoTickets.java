package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {

    private final List<LottoTicket> ticketList;

    public LottoTickets(List<LottoTicket> ticketList) {
        this.ticketList = ticketList;
    }

    public Rewards check(WinningLottoNumber winningNumbers) {
        return this.ticketList.stream()
                .map(winningNumbers::check)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Rewards::new));
    }

    public LottoTickets merge(final LottoTickets otherTickets) {
        List<LottoTicket> mergeLottoList = Stream.concat(this.ticketList.stream(), otherTickets.ticketList.stream())
                .collect(Collectors.toList());
        return new LottoTickets(mergeLottoList);
    }

    public int getTicketCount() {
        return this.ticketList.size();
    }

    @Override
    public String toString() {
        return ticketList.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(ticketList, that.ticketList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketList);
    }
}
