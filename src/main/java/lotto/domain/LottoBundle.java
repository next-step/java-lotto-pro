package lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoTickets;

    public LottoBundle(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int size() {
        return lottoTickets.size();
    }
}
