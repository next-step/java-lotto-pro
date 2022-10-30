package lotto.model.lotto.ticket;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsBucket {
    protected final List<LottoTicket> lottoTickets;

    public LottoTicketsBucket(int howManyTickets) {
        if (!isZeroOrPositive(howManyTickets)) {
            throw new IllegalStateException("구매하려는 로또 개수가 올바르지 않습니다.");
        }
        lottoTickets = new ArrayList<>(howManyTickets);
    }

    private boolean isZeroOrPositive(int howManyTickets) {
        return 0 <= howManyTickets;
    }

    public void addLottoTicket(LottoTicket lottoTicket) {
        lottoTickets.add(lottoTicket);
    }
}
