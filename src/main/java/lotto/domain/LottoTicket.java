package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Lotto> lottos;
    public LottoTicket(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return lottos.size();
    }

    public Ranks check(final Ranks ranks, final WinningLotto winninglotto) {
        for(Lotto lotto : lottos) {
            ranks.add(lotto.compareTo(winninglotto));
        }
        return ranks;
    }
}
