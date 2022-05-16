package lotto.domain;

import lotto.type.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Lotto, LottoRank> lottoResultMap;
    public LottoResult(Lottos lottos, Lotto answerLotto) {
        lottoResultMap = new HashMap<>();

        lottos.getLottos().forEach(lotto -> {
            lottoResultMap.put(lotto, LottoRank.findLottoRankByMatchedCount(countMatchedNumber(lotto, answerLotto)));
        });
    }

    public Map<Lotto, LottoRank> getLottoResultMap() {
        return lottoResultMap;
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
