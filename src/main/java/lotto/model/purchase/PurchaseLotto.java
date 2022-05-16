package lotto.model.purchase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.model.lotto.Lotto;
import lotto.model.result.LottoResult;
import lotto.model.winning.WinningLotto;
import lotto.type.LottoRank;

public class PurchaseLotto {

    private List<Lotto> lottoList;

    public PurchaseLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public LottoResult rankMatch(WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankMap = new HashMap<>();
        Arrays.stream(LottoRank.values())
            .forEach(lottoRank -> rankMap.put(lottoRank, 0));

        lottoList.forEach(lotto -> {
            Optional<LottoRank> lottoRank = LottoRank.rankMatch(lotto.match(winningLotto));
            lottoRank.ifPresent(rank -> rankMap.put(rank, rankMap.get(rank) + 1));
        });

        return new LottoResult(rankMap);
    }

}
