package lotto.model.enums;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final String NORMAL_MATCH_STATEMENT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_MATCH_STATEMENT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.getCountOfMatch() && matchBonus) {
            return SECOND;
        }
        if (countOfMatch == THIRD.getCountOfMatch() && !matchBonus) {
            return THIRD;
        }
        return Arrays.stream(values())
            .filter(rank -> rank.getCountOfMatch() == countOfMatch)
            .findFirst()
            .orElse(MISS);
    }

    public static List<Rank> getRanksHavingWinningMoney() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public String computeMatchStatement(int totalCount) {
        return String.format(getMatchStatementFormat(), getCountOfMatch(), getWinningMoney(), totalCount);
    }

    private String getMatchStatementFormat() {
        if (this == SECOND) {
            return SECOND_MATCH_STATEMENT_FORMAT;
        }
        return NORMAL_MATCH_STATEMENT_FORMAT;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
