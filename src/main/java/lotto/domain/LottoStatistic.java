package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoStatistic {

    private Map<MatchResult, Lottos> matchedLottos;

    public LottoStatistic(Lottos lottos, WinningNumbers winningNumbers) {
        initializePrizeLottoList(lottos, winningNumbers);
    }

    public LottoStatistic(Lottos lottos, String[] winningNumbers) {
        this(lottos, createWinningNumbers(winningNumbers));
    }

    private static WinningNumbers createWinningNumbers(String[] numbers) {
        LottoNumber[] winningNumbers = new LottoNumber[numbers.length];
        for (int index = 0; index < winningNumbers.length; index++) {
            winningNumbers[index] = LottoNumber.from(numbers[index]);
        }
        return new WinningNumbers(winningNumbers);
    }

    private void initializePrizeLottoList(Lottos lottos, WinningNumbers winningNumbers) {
        matchedLottos = new HashMap<>();
        for (MatchResult matchResult : MatchResult.values()) {
            matchedLottos.put(matchResult, lottos.matchedLottoList(winningNumbers, matchResult));
        }
    }

    public int matchedCount(MatchResult matchResult) {
        return matchedLottos.get(matchResult).size();
    }

    public BigDecimal lottoEarning() {
        Money totalLottoPrice = Money.from(0);
        for (Lottos lottos : matchedLottos.values()) {
            totalLottoPrice = totalLottoPrice.add(lottos.totalPrice());
        }
        return totalPrize().divide(totalLottoPrice);
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
