package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottos;

    private LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket from(List<Lotto> lottos) {
        return new LottoTicket(lottos);
    }

    public List<Lotto> getReadOnlyLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getCount() {
        return this.lottos.size();
    }
}
