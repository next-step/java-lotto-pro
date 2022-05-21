package lotto.domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistic {

    private Map<MatchResult, Lottos> matchedLottos;

    public LottoStatistic(Lottos lottos, WinningLotto winningLotto) {
        initializePrizeLottoList(lottos, winningLotto);
    }

    public LottoStatistic(Lottos lottos, String[] winningNumbers, String bonusNumber) {
        this(lottos, new WinningLotto(winningNumbers, bonusNumber));
    }

    private void initializePrizeLottoList(Lottos lottos, WinningLotto winningNumbers) {
        matchedLottos = new HashMap<>();
        for (MatchResult matchResult : MatchResult.values()) {
            matchedLottos.put(matchResult, lottos.matchedLottoList(winningNumbers, matchResult));
        }
    }

    public BigDecimal lottoEarning() {
        Money totalLottoPrice = Money.from(0);
        for (Lottos lottos : matchedLottos.values()) {
            totalLottoPrice = totalLottoPrice.add(lottos.totalPrice());
        }
        return totalPrize().divide(totalLottoPrice);
    }

    public Map<MatchResult, Integer> winningMatchResultCount() {
        Map<MatchResult, Integer> result = new HashMap<>();
        for (MatchResult matchResult : MatchResult.winningMatchResults()) {
            result.put(matchResult, matchedCount(matchResult));
        }
        return result;
    }

    private int matchedCount(MatchResult matchResult) {
        return matchedLottos.get(matchResult).size();
    }

    private Money totalPrize() {
        Money result = Money.from(0);
        for (Map.Entry<MatchResult, Lottos> entry : matchedLottos.entrySet()) {
            result = result.add(calculatePrize(entry));
        }
        return result;
    }

    private Money calculatePrize(Entry<MatchResult, Lottos> entry) {
        Money result = Money.from(0);
        for (int index = entry.getValue().size(); index > 0; index--) {
            result = result.add(entry.getKey().getCashPrize());
        }
        return result;
    }
}
