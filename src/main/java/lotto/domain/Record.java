package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Record {
    private static final int DEFAULT_COUNT_ZERO = 0;
    private static final int DEFAULT_PRICE = 5000;

    private final Map<Rank, Integer> record = new HashMap<>();
    private final Money totalPayment;
    private final Money totalWinningMoney;

    public Record(LotteryTicket lotteryTicket, LottoNumbers winningNumber) {
        initRecord(lotteryTicket, winningNumber);
        this.totalPayment = Money.of(calcTotalPayment(lotteryTicket));
        this.totalWinningMoney = calcTotalWinningMoney();
    }

    private void initRecord(LotteryTicket lotteryTicket, LottoNumbers winningNumber) {
        lotteryTicket.writeRecord(this, winningNumber);
    }

    public void increaseMatchedCount(Rank matchedCount) {
        Integer count = record.getOrDefault(matchedCount, DEFAULT_COUNT_ZERO);
        record.put(matchedCount, count + 1);
    }

    private int calcTotalPayment(LotteryTicket lotteryTicket) {
        return lotteryTicket.size() * DEFAULT_PRICE;
    }

    private Money calcTotalWinningMoney() {
        Money total = Money.of(0);
        for (Rank rank : Rank.values()) {
            total = total.plus(rank.getWinningMoney(this));
        }
        return total;
    }

    public int getWinningCount(Rank rank) {
        return rank.getCount(this);
    }

    public int get(Rank rank) {
        return record.getOrDefault(rank, DEFAULT_COUNT_ZERO);
    }

    public Money getWinningMoney(Rank rank) {
        return rank.getWinningMoney(this);
    }

    public Money getTotalWinningMoney() {
        return totalWinningMoney;
    }

    public double getProfitRate() {
        return totalWinningMoney.divide(totalPayment).doubleValue();
    }
}
