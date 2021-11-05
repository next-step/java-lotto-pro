package study.lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(final int countOfMatch) {
//        validateCountOfMatch(countOfMatch);
        final Rank[] values = values();
        return Arrays.stream(values)
                .filter(rank -> rank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(Rank.MISS);

    }

    public static List<Rank> getRanksOrderByWinningMoneyDesc() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::getWinningMoney).reversed())
                .collect(Collectors.toList());
    }
//    private static void validateCountOfMatch(final int countOfMatch) {
//        throw new IllegalRankCountOfMatchException("매치된 수와 맞는 랭크를 찾을 수 없습니다.");
//    }
}