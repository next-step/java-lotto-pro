package lotto.domain;

import lotto.service.LottoIssuedService;
import lotto.type.LottoRank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

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
        this.lottos.forEach(lotto -> {
            lottoRankMap.put(lotto, LottoRank.findLottoRankByMatchedCount(countMatchedNumber(lotto, answerLotto)));
        });
        return lottoRankMap;
    }

    public static int countMatchedNumber(Lotto lotto, Lotto answerLotto) {
        List<Integer> answerLottoNumbers = answerLotto.getLottoNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());

        return (int) lotto.getLottoNumbers().stream()
                .filter(lottoNumber -> answerLottoNumbers.contains(lottoNumber.getNumber()))
                .mapToInt(LottoNumber::getNumber)
                .count();
    }
}
