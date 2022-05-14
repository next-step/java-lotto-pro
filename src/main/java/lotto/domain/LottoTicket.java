package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<LottoNumbers> lottos;

    private LottoTicket(List<LottoNumbers> lottos) {
        this.lottos = lottos;
    }

    public static LottoTicket from(List<LottoNumbers> lottos) {
        return new LottoTicket(lottos);
    }

    public List<LottoNumbers> getReadOnlyLottoNumbers() {
        return Collections.unmodifiableList(this.lottos);
    }

    public int getCount() {
        return this.lottos.size();
    }
}
