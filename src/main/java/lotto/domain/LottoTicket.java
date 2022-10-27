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
}
