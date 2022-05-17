package lotto.domain;

import java.util.List;
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

    public LottosResults matchWithReference(Lotto referenceLotto) {
        LottosResults results = new LottosResults();

        for(Lotto lotto : lottoList) {
            matchLottoWithReference(results, referenceLotto, lotto);
        }

        return results;
    }

    private void matchLottoWithReference(LottosResults results, Lotto referenceLotto, Lotto targetLotto) {
        LottoRank matchedRank = referenceLotto.match(targetLotto).convertToLottoRank();
        results.increaseRankCount(matchedRank);
    }
}
