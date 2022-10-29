package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public int ticketCount() {
        return this.lottoTicketList.size();
    }

    public int ticketListPrice() {
        return this.lottoTicketList.size() * 1000;
    }

    public void matchLottoResult(LottoNumbers winningLottoNumber, LottoResult lottoResult) {
        for (LottoTicket lottoTicket : lottoTicketList) {
            lottoResult.increaseRankCount(lottoTicket.compareLotto(winningLottoNumber));
        }
    }

    @Override
    public String toString() {
        return this.lottoTicketList.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }

}
