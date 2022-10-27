package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public List<Lotto> auto(int lottoTicketCount) {
        ArrayList<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(new Lotto());
        }
        return lottoTickets;
    }
}
