package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓(LottoTicket) 여러 개를 저장하고 관리하는 객체이다.
 */
public class LottoTicketsBucket {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        lottoTickets = new ArrayList<>(howManyTickets);
        for (int i = 0; i < howManyTickets; ++i) {
            lottoTickets.add(new LottoTicket());
        }
    }
}
