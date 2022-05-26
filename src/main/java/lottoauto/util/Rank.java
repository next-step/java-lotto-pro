package lottoauto.util;

import lottoauto.wrapper.Price;

import java.util.Arrays;
import java.util.Map;

public enum Rank {
    FIRST(1, 6, 2_000_000_000, "6개 일치(2000000000원)-"),
    SECOND(2, 5, 30_000_000, "5개 일치(300000000), 보너스 볼 일치-"),
    THIRD(3, 5, 1_500_000, "5개 일치(1500000원)-"),
    FOURTH(4, 4, 50_000, "4개 일치(50000원)-"),
    FIFTH(5, 3, 5_000, "3개 일치(5000원)-"),
    MISS(0, 0, 0, "0개 일치(0원)-");


    private int countOfMatch;
    private int winningMoney;
    private int lottoRank;
    private String lottoString;

    Rank(int lottoRank, int countOfMatch, int winningMoney, String lottoString) {
        this.lottoRank = lottoRank;
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.lottoString = lottoString;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getLottoRank() {
        return lottoRank;
    }

    public String getLottoString() {
        return lottoString;
    }

    private boolean sameMatchedCount(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if (SECOND.sameMatchedCount(countOfMatch) && matchBonus) {
            return SECOND;
        }
        return Arrays.stream(values()).filter(rank -> rank.getCountOfMatch() == countOfMatch).findFirst().orElse(MISS);
    }

    public static double getYield(Map<Integer, Integer> winnerMap, Price price) {
        int yieldSum = 0;
        Rank rank[] = Rank.values();
        for (int i = 0 ; i < winnerMap.size() ; i++) {
            yieldSum += rank[i].getWinningMoney() * winnerMap.get(rank[i].getLottoRank());
        }
        return yieldSum / price.getPrice();
    }
}


