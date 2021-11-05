package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    public LottoTickets() {
        this.lottoTickets = new ArrayList<>();
    }

    public static LottoTickets from(List<LottoTicket> tickets) {
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(tickets);
        return lottoTickets;
    }

    public void add(List<LottoTicket> lottoTickets) {
        if (lottoTickets == null) {
            throw new NullPointerException("추가할 로또 티켓이 없습니다.");
        }
        this.lottoTickets.addAll(lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
