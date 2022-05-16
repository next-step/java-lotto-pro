package lotto.domain;

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

    public double lottoEarning() {
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


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("당첨 통계\n" + "---------\n");

        builder.append(toMatchResultString(MatchResult.THREE));

        builder.append(toMatchResultString(MatchResult.FOUR));

        builder.append(toMatchResultString(MatchResult.FIVE));

        builder.append(toMatchResultString(MatchResult.SIX));

        builder.append(toEarningString());

        return builder.toString();
    }

    private String toMatchResultString(MatchResult matchResult) {
        return matchResult.getMatchCount() + "개 일치" + "(" + matchResult.getCashPrize().toString()
                + ")- " + matchedCountMap.get(
                matchResult) + "개\n";
    }

    private String toEarningString() {
        String result;
        double totalEarning = lottoEarning();
        result = "총 수익률은 " + String.format("%.2f", totalEarning) + " 입니다.";
        if (totalEarning > 1) {
            result = result + "(기준이 1이기 때문에 결과적으로 이득이라는 의미임)";
        }
        result = result + "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

        return result;
    }
}
