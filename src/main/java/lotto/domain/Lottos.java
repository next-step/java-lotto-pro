package lotto.domain;

import lotto.type.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Lotto, LottoRank> lottoWinningResult(LottoWinning lottoWinning) {
        Map<Lotto, LottoRank> lottoRankMap = new HashMap<>();
        this.lottos.forEach(
                lotto -> lottoRankMap.put(lotto, lotto.checkLottoRank(lottoWinning))
        );

        return lottoRankMap;
    }
}
