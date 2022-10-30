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

    public void matchLottoResult(WinningLottoNumbers winningLottoNumber, LottoResult lottoResult) {
        for (LottoTicket lottoTicket : lottoTicketList) {
            lottoResult.increaseRankCount(lottoTicket.compareLotto(winningLottoNumber.getLottoNumbers()));
        }
    }

    @Override
    public String toString() {
        return this.lottoTicketList.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }

}
