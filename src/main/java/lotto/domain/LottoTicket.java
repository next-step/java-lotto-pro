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

    public Integer countLottoRank(LottoRank lottoRank, LottoWinningNumbers lottoWinningNumbers) {
        return Math.toIntExact(lottoTicket.stream()
                .map(lottoWinningNumbers::compareLottoNumbers)
                .filter(rank -> rank.equals(lottoRank))
                .count());
    }

}
