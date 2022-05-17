package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistic {
    private Lottos lottos;
    private WinningNumbers winningNumbers;
    private Map<MatchResult, Integer> matchedCountMap;

    public LottoStatistic(Lottos lottos, WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        initializePrizeLottoList();
    }

    public LottoStatistic(Lottos lottos, String[] winningNumbers) {
        this.lottos = lottos;

        LottoNumber[] numbers = new LottoNumber[winningNumbers.length];

        for (int index = 0; index < winningNumbers.length; index++) {
            numbers[index] = LottoNumber.from(winningNumbers[index]);
        }
        this.winningNumbers = new WinningNumbers(numbers);
        initializePrizeLottoList();
    }

    private void initializePrizeLottoList() {
        matchedCountMap = new HashMap<>();
        matchedCountMap.put(MatchResult.THREE, lottos.matchedLottoList(winningNumbers, MatchResult.THREE).size());
        matchedCountMap.put(MatchResult.FOUR, lottos.matchedLottoList(winningNumbers, MatchResult.FOUR).size());
        matchedCountMap.put(MatchResult.FIVE, lottos.matchedLottoList(winningNumbers, MatchResult.FIVE).size());
        matchedCountMap.put(MatchResult.SIX, lottos.matchedLottoList(winningNumbers, MatchResult.SIX).size());
    }

    public int matchedCount(MatchResult matchResult) {
        return matchedCountMap.get(matchResult);
    }

    public BigDecimal lottoEarning() {
        return totalPrize().divide(this.lottos.totalPrice());
    }


    private Money totalPrize() {
        Money result = Money.from(0);
        for (Map.Entry<MatchResult, Integer> entry : matchedCountMap.entrySet()) {
            result = result.add(calculatePrize(entry));
        }
        return result;
    }

    private Money calculatePrize(Entry<MatchResult, Integer> entry) {
        Money result = Money.from(0);
        for (int index = entry.getValue(); index > 0; index--) {
            result = result.add(entry.getKey().getCashPrize());
        }
        return result;
    }
}
