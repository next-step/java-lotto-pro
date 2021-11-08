package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000),
    LOSER(0 ,0);

    private static Map<Integer, Rank> rankMap = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            rankMap.put(rank.getWinningNumberCount(), rank);
        }
    }

    private int winningNumberCount;
    private int prizeMoney;

    Rank(int winningNumberCount, int prizeMoney) {
        this.winningNumberCount = winningNumberCount;
        this.prizeMoney = prizeMoney;
    }

    static Rank of(int winningNumberCount) {
        Rank rank = rankMap.get(winningNumberCount);
        if (rank == null) {
            return LOSER;
        }
        return rank;
    }

    public boolean isPrize() {
        return this != Rank.LOSER;
    }

    public long prizeMoneyCalculation(int winningCount) {
        return (long) this.prizeMoney * winningCount;
    }

    public int getWinningNumberCount() {
        return winningNumberCount;
    }
}
