package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTicket {

    private final List<LottoNumbers> lottoTicket;

    public LottoTicket(List<LottoNumbers> lottoTicket) {
        this.lottoTicket = Collections.unmodifiableList(new ArrayList<>(lottoTicket));
    }

    public List<LottoNumbers> getLottoTicket() {
        return lottoTicket;
    }

    public Map<LottoRank, Integer> countLottoRank(LottoWinningNumbers lottoWinningNumbers) {
        return lottoTicket.stream()
                .map(lottoWinningNumbers::compareLottoNumbers)
                .collect(Collectors.toMap(rank -> rank, rank -> 1, Integer::sum));
    }

}
