package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistic {

    private Map<MatchResult, Integer> matchedCount;

    public LottoStatistic(Lottos lottos, WinningLotto winningLotto) {
        initializePrizeLottos(lottos, winningLotto);
    }

    public LottoStatistic(Lottos lottos, String[] winningNumbers, String bonusNumber) {
        this(lottos, new WinningLotto(winningNumbers, bonusNumber));
    }

    private void initializePrizeLottos(Lottos lottos, WinningLotto winningNumbers) {
        matchedCount = new HashMap<>();
        for (MatchResult matchResult : MatchResult.values()) {
            matchedCount.put(matchResult, lottos.matchedLottos(winningNumbers, matchResult).size());
        }
    }

    public BigDecimal calculateLottoEarning() {
        Money totalLottoPrice = getTotalLottoPrice();
        return totalPrize().divide(totalLottoPrice);
    }

    private Money getTotalLottoPrice() {
        Money totalLottoPrice = Money.from(0);
        for (int count : matchedCount.values()) {
            totalLottoPrice = totalLottoPrice.add(Lotto.LOTTO_PRICE.multiply(count));
        }
        return totalLottoPrice;
    }

    public Map<MatchResult, Integer> winningMatchResultCount() {
        Map<MatchResult, Integer> result = new HashMap<>();
        for (MatchResult matchResult : MatchResult.winningMatchResults()) {
            result.put(matchResult, matchedCount(matchResult));
        }
        return result;
    }

    private int matchedCount(MatchResult matchResult) {
        return matchedCount.get(matchResult);
    }

    private Money totalPrize() {
        Money result = Money.from(0);
        for (Map.Entry<MatchResult, Integer> entry : matchedCount.entrySet()) {
            result = result.add(calculatePrize(entry));
        }
        return result;
    }

    private Money calculatePrize(Entry<MatchResult, Integer> entry) {
        Money cashPrize = entry.getKey().getCashPrize();
        int matchedCount = entry.getValue();
        return cashPrize.multiply(matchedCount);
    }
}
