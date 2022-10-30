package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;
    public LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Ranks check(final WinningLotto winninglotto) {
        final Ranks ranks = new Ranks();
        for(Lotto lotto : lottos) {
            ranks.add(lotto.compareTo(winninglotto));
        }
        return ranks;
    }
}
