package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistic {
    private Lottos lottos;
    private List<LottoNumber> prizeNumbers;
    private Map<MatchResult, Integer> matchedCountMap;
    
    public LottoStatistic(Lottos lottos, List<LottoNumber> prizeNumbers) {
        this.lottos = lottos;
        this.prizeNumbers = new ArrayList<>(prizeNumbers);
        initializePrizeLottoList();

    }

    private void initializePrizeLottoList() {
        matchedCountMap = new HashMap<>();
        matchedCountMap.put(MatchResult.THREE, lottos.matchedLottoList(prizeNumbers, MatchResult.THREE).size());
        matchedCountMap.put(MatchResult.FOUR, lottos.matchedLottoList(prizeNumbers, MatchResult.FOUR).size());
        matchedCountMap.put(MatchResult.FIVE, lottos.matchedLottoList(prizeNumbers, MatchResult.FIVE).size());
        matchedCountMap.put(MatchResult.SIX, lottos.matchedLottoList(prizeNumbers, MatchResult.SIX).size());
    }

    public int matchedCount(MatchResult matchResult) {
        return matchedCountMap.get(matchResult);
    }

    public double lottoEarning() {
        return totalPrize().divide(this.lottos.totalPrice());
    }

    private Money totalPrize() {
        Money result = Money.from(0);
        for (Map.Entry<MatchResult, Integer> entry : matchedCountMap.entrySet()) {
            for (int index = entry.getValue(); index > 0; index--) {
                result = result.add(entry.getKey().getCashPrize());
            }
        }
        return result;
    }


}
