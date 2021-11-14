package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {

    private final List<LottoNumbers> lottoTicket;

    public LottoTicket(List<LottoNumbers> lottoTicket) {
        this.lottoTicket = Collections.unmodifiableList(new ArrayList<>(lottoTicket));
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }

    public long countLottoRank(LottoRank lottoRank, LottoWinningNumbers lottoWinningNumbers) {
        return lottoTicket.stream()
                .map(lottoWinningNumbers::compareLottoNumbers)
                .filter(rank -> rank.equals(lottoRank))
                .count();
    }

}
