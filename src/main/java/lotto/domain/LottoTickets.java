package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoTickets {
    private List<LottoTicket> lottoTicketList;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTicketList = lottoTickets;
    }

    public LottoResults calculateResult(LottoTicket winnerTicket) {
        return new LottoResults(lottoTicketList.stream()
            .map(lottoTicket -> lottoTicket.calculateResult(winnerTicket))
            .collect(Collectors.toList()));
    }

    public List<LottoTicket> getLottoTicketList() {
        return lottoTicketList;
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
}
