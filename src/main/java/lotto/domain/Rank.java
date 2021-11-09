package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public enum Rank {

    FIRST_PLACE(6, 2_000_000_000, false),
    SECOND_PLACE(5, 1_500_000, false),
    BONUS_SECOND_PLACE(5, 30_000_000, true),
    THIRD_PLACE(4, 50_000, false),
    FOURTH_PLACE(3, 5_000, false),
    LOSER(0 ,0, false);

    private static Map<Integer, Map<Boolean, Rank>> rankMap = new HashMap<>();

    static {
        for (Rank rank : Rank.values()) {
            Map<Boolean, Rank> accordingToBonusRankMap = rankMap.computeIfAbsent(rank.getWinningNumberCount(), key -> new HashMap<>());
            accordingToBonusRankMap.put(rank.isBonus, rank);
            rankMap.put(rank.getWinningNumberCount(), accordingToBonusRankMap);
        }
    }

    private int winningNumberCount;
    private int prizeMoney;
    private boolean isBonus;

    Rank(int winningNumberCount, int prizeMoney, boolean isBonus) {
        this.winningNumberCount = winningNumberCount;
        this.prizeMoney = prizeMoney;
        this.isBonus = isBonus;
    }

    static Rank of(int winningNumberCount, boolean matchBonus) {
        Map<Boolean, Rank> rank = rankMap.get(winningNumberCount);
        if (rank == null) {
            return LOSER;
        }
        if (isRankWithoutBonus(rank, matchBonus)) {
            return rank.get(false);
        }
        return rank.get(matchBonus);
    }

    private static boolean isRankWithoutBonus(Map<Boolean, Rank> rank, boolean matchBonus) {
        return rank.get(matchBonus) == null;
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
