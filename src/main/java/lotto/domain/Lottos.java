package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class Lottos {

    private static final String ERROR_MESSAGE_LOTTO_LIST_NULL_OR_EMPTY = "[ERROR] lottoList is null or empty.";
    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        validate(lottoList);
        this.lottoList = lottoList;
    }

    private void validate(List<Lotto> lottoList) {
        if(lottoList == null || lottoList.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LOTTO_LIST_NULL_OR_EMPTY);
        }
    }

    public Lotto get(int index) {
        return lottoList.get(index);
    }

    public int size() {
        return lottoList.size();
    }

    public LottosResults matchWithReference(Lotto referenceLotto, LottoNumber bonusNumber) {
        Map<LottoRank, Integer> rankCountMap = new HashMap<>();

        for(Lotto lotto : lottoList) {
            LottoRank lottoRank = matchLottoWithReference(referenceLotto, bonusNumber, lotto);
            countRank(rankCountMap, lottoRank);
        }

        return new LottosResults(rankCountMap);
    }

    private LottoRank matchLottoWithReference(Lotto referenceLotto, LottoNumber bonusNumber, Lotto targetLotto) {
        return targetLotto.match(referenceLotto, bonusNumber).convertToLottoRank();
    }

    private void countRank(Map<LottoRank, Integer> rankCountMap, LottoRank lottoRank) {
        if(rankCountMap.containsKey(lottoRank)) {
            rankCountMap.put(lottoRank, rankCountMap.get(lottoRank) + 1);
            return;
        }

        rankCountMap.put(lottoRank, 1);
    }
}
