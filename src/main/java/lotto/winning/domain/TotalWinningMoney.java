package lotto.winning.domain;

import common.vo.Count;

import java.util.HashMap;
import java.util.Map;

import static lotto.winning.domain.WinningMoneyType.find;

public class TotalWinningMoney {

    public static final int THREE_MATCH_COUNT = 3;
    public static final int FOUR_MATCH_COUNT = 4;
    public static final int FIVE_MATCH_COUNT = 5;
    public static final int SIX_MATCH_COUNT = 6;
    private Map<Integer, Count> winningMonies = new HashMap<>();

    protected TotalWinningMoney() {
    }

    public TotalWinningMoney(MatchCount matchCount) {
        winningMonies.put(THREE_MATCH_COUNT, matchCount.matchCount(THREE_MATCH_COUNT));
        winningMonies.put(FOUR_MATCH_COUNT, matchCount.matchCount(FOUR_MATCH_COUNT));
        winningMonies.put(FIVE_MATCH_COUNT, matchCount.matchCount(FIVE_MATCH_COUNT));
        winningMonies.put(SIX_MATCH_COUNT, matchCount.matchCount(SIX_MATCH_COUNT));
    }

    public Map<Integer, Count> getWinningMonies() {
        return this.winningMonies;
    }

    public long sum() {
        long sum = 0;
        for (Integer matchCount : this.winningMonies.keySet()) {
            sum += winningMoney(matchCount) * matchedLottoCount(matchCount);
        }
        return sum;
    }

    private static long winningMoney(Integer matchCount) {
        return find(matchCount).getMoney();
    }

    private int matchedLottoCount(Integer matchCount) {
        return this.winningMonies.get(matchCount).getNumber();
    }
}
