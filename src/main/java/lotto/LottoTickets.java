package lotto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import view.Printable;

public class LottoTickets implements Printable {
    private List<LottoTicket> lottoTicketList;

    private static final String NEW_LINE = "\n";

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTicketList = lottoTickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LottoTickets)) {
            return false;
        }
        LottoTickets that = (LottoTickets)o;
        return Objects.equals(lottoTicketList, that.lottoTicketList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTicketList);
    }

    @Override
    public String makePrintableMessage() {
        return lottoTicketList.stream().map(LottoTicket::makePrintableMessage).collect(Collectors.joining(NEW_LINE));
    }
}
