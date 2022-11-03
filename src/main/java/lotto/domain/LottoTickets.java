package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public int ticketCount() {
        return lottoTicketList.size();
    }

    public void lottoWinningConfirm(WinningLottoNumbers winningLottoNumber, LottoResult lottoResult) {
        lottoTicketList.stream().forEach(lottoTicket -> {
            lottoTicket.lottoWinningConfirm(winningLottoNumber);
            lottoResult.increaseRankCount(lottoTicket.getLottoRankResult());
        });
    }

    public int autoTicketCount(int manualTicketCount) {
        return lottoTicketList.size() - manualTicketCount;
    }

    @Override
    public String toString() {
        return this.lottoTicketList.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }

}
