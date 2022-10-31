package step3.constant;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, "6개 일치 "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 "),
    THIRD(5, 1_500_000, "5개 일치 "),
    FOURTH(4, 50_000, "4개 일치 "),
    FIFTH(3, 5_000, "3개 일치 "),
    MISS(0, 0, null);

    private int countOfMatch;
    private int winningMoney;
    private String sameCountMessage;

    private Rank(int countOfMatch, int winningMoney, String sameCountMessage) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.sameCountMessage = sameCountMessage;
    }

    public static Rank search(int sameNumber, boolean isBonus) {
        if (isBonus && SECOND.countOfMatch == sameNumber) {
            return SECOND;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.countOfMatch == sameNumber)
                .findFirst()
                .orElse(MISS);
    }

    public String sameCountMessage() {
        return sameCountMessage;
    }

    public int winningMoney() {
        return winningMoney;
    }
}
