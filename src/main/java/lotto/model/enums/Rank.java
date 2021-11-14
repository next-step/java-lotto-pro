package lotto.model.enums;

import java.util.Arrays;
import java.util.List;

import lotto.model.Lotto;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private static final String NORMAL_MATCH_STATEMENT_FORMAT = "%d개 일치 (%d원) - %d개";
    private static final String SECOND_MATCH_STATEMENT_FORMAT = "%d개 일치, 보너스 볼 일치 (%d원) - %d개";
    private static final String COUNT_OF_MATCH_SIZE_ERR_MSG = "매칭된 숫자의 갯수가 0보다 작거나 6보다 클 수는 없습니다.";

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        validate(countOfMatch);
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

    private static void validate(int countOfMatch) {
        if (countOfMatch < 0 || countOfMatch > Lotto.NUMBER_SIZE) {
            throw new IllegalArgumentException(COUNT_OF_MATCH_SIZE_ERR_MSG);
        }
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

    private int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
