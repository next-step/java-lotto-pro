package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.common.ConstValue.LOTTO_PRICE;

public class LottoTickets {

    private final List<LottoTicket> lottoTicketList;

    public LottoTickets(List<LottoTicket> lottoTicketList) {
        this.lottoTicketList = lottoTicketList;
    }

    public int ticketCount() {
        return this.lottoTicketList.size();
    }

    public int ticketListPrice() {
        return this.lottoTicketList.size() * LOTTO_PRICE;
    }

    public void lottoWinningConfirm(WinningLottoNumbers winningLottoNumber, LottoResult lottoResult) {
        lottoTicketList.stream().forEach(lottoTicket -> {
            lottoTicket.lottoWinningConfirm(winningLottoNumber);
            lottoResult.increaseRankCount(lottoTicket.getLottoRankResult());
        });
    }

    @Override
    public String toString() {
        return this.lottoTicketList.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }

}
