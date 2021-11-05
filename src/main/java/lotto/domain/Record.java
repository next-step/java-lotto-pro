package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Record {
    public static final int DEFAULT_COUNT_ZERO = 0;
    public static final int DEFAULT_PRICE = 5000;

    private final Map<Integer, Integer> record = new HashMap<>();
    private final Money totalPayment;
    private final Money totalWinningMoney;

    public Record(List<LottoNumbers> lottoNumbersList, LottoNumbers winningNumber) {
        initRecord(lottoNumbersList, winningNumber);
        this.totalPayment = Money.of(calcTotalPayment(lottoNumbersList));
        this.totalWinningMoney = Money.of(calcTotalWinningMoney());
    }

    private void initRecord(List<LottoNumbers> lottoNumbersList, LottoNumbers winningNumber) {
        for (LottoNumbers numbers : lottoNumbersList) {
            int matchedCount = numbers.getMatchedCount(winningNumber);
            Integer count = record.getOrDefault(matchedCount, DEFAULT_COUNT_ZERO);
            record.put(matchedCount, count + 1);
        }
    }

    private int calcTotalPayment(List<LottoNumbers> lottoNumbersList) {
        return lottoNumbersList.size() * DEFAULT_PRICE;
    }

    private long calcTotalWinningMoney() {
        long total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getWinningMoney(this);
        }
        return total;
    }

    public int getWinningCount(Rank rank) {
        return rank.getCount(this);
    }

    public int get(int matchedCount) {
        return record.get(matchedCount);
    }

    public Money getWinningMoney(Rank rank) {
        return Money.of(rank.getWinningMoney(this));
    }

    public Money getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public double getProfitRate() {
        return totalWinningMoney.divide(totalPayment).doubleValue();
    }
}
