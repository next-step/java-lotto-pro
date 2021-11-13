package study.lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(0,6, 2_000_000_000),
    SECOND(0,5, 30_000_000),
    THIRD(0,5, 1_500_000),
    FOURTH(0,4, 50_000),
    FIFTH(0,3, 5_000),
    MISS(0,0, 0);

    private int correct;
    private int countOfMatch;
    private int winningMoney;

    private Rank(int correct, int countOfMatch, int winningMoney) {
        this.correct = correct;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
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

    private boolean isMiss() {
        return this == MISS;
    }

    public void increaseCorrect() {
        this.correct++;
    }

    public String makePrintFormat() {
        String format = "";
        if(isSecond())
            format = String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개\n", countOfMatch, winningMoney, correct);
        if(!isMiss() && !isSecond())
            format = String.format("%d개 일치 (%d원)- %d개\n", countOfMatch, winningMoney, correct);
        return format;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getCorrect() {
        return correct;
    }

    public void initCorrect() {
        for(Rank rank : Rank.values()) {
            this.correct = 0;
        }
    }
}