package study.temp.lotto.auto;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private Ranking(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Ranking valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == SECOND.countOfMatch && matchBonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(lottoRank -> !lottoRank.isSecond())
                .filter(lottoRank -> lottoRank.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(MISS);
    }

    private boolean isSecond() {
        return this == SECOND;
    }

    public String makePrintFormat() {
        String format;
        if(isSecond()) {
            format = String.format("%d개 일치, 보너스 볼 일치 (%d원)- ", countOfMatch, winningMoney);
        }
        format = String.format("%d개 일치 (%d원)- ", countOfMatch, winningMoney);
        return format;
    }
}