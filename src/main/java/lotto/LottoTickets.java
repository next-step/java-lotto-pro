package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private List<LottoTicket> lottoTicketList;

    public LottoTickets(int count) {
        lottoTicketList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottoTicketList.add(new LottoTicket());
        }
    }

    public int getSize() {
        return lottoTicketList.size();
    }
}
