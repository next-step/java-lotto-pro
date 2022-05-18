package lotto.domain;

import lotto.service.LottoIssuedService;
import lotto.type.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos( LottoIssuedService lottoIssuedService, int lottoPurchaseCount) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++)
            this.lottos.add(new Lotto(lottoIssuedService.issueLottoNumber()));
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Lotto, LottoRank> lottoWinningResult(Lotto answerLotto) {
        Map<Lotto, LottoRank> lottoRankMap = new HashMap<>();
        this.lottos.forEach(
                lotto -> lottoRankMap.put(
                        lotto, LottoRank.findLottoRankByMatchedCount(countMatchedNumber(lotto, answerLotto))
                )
        );

        return lottoRankMap;
    }

    public static int countMatchedNumber(Lotto lotto, Lotto answerLotto) {
        List<Integer> answerLottoNumbers = new ArrayList<>(answerLotto.getLottoNumbers());

        return (int) lotto.getLottoNumbers().stream()
                .filter(answerLottoNumbers::contains)
                .count();
    }

    public boolean checkCorrectBonusBall() {
        return false;
    }
}
