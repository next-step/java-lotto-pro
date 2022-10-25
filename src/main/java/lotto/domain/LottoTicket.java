package lotto.domain;

import java.util.List;

public class LottoTicket {
    private final List<Lotto> lottoList;
    public LottoTicket(final List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
