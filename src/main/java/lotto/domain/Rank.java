package lotto.domain;

import java.util.Arrays;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000, false, "6개 일치(2000000000원)")
    , SECOND(5, 30000000, true, "5개 일치, 보너스 볼 일치(30000000원)")
    , THIRD(5, 1500000, false, "5개 일치(1500000원)")
    , FOURTH(4, 50000, false, "4개 일치(50000원)")
    , FIFTH(3, 5000, false, "3개 일치(5000원)");

    private static int SECOND_AND_THIRD_MATCH_NUM = 5;
    private int countOfMatch;
    private int winningMoney;
    private boolean matchBonus;
    private String prizeString;

    private Rank(int countOfMatch, int winningMoney, boolean matchBonus, String prizeString) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
        this.prizeString = prizeString;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
    
    public String getPrizeString() {
        return prizeString;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        Stream<Rank> stream = Arrays.stream(values()).filter(r -> (r.countOfMatch == countOfMatch));
        
        if(countOfMatch == SECOND_AND_THIRD_MATCH_NUM) {
            return stream.filter(r -> (r.matchBonus == matchBonus)).findFirst().orElse(Rank.THIRD);
        }
        return stream.findFirst().orElse(null);
    }
}
