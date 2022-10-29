package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓(LottoTicket) 여러 개를 저장하고 관리하는 객체이다.
 */
public class LottoTicketsBucket {
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        this.lottoTickets = new ArrayList<>(howManyTickets);
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }
}
