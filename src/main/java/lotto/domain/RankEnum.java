package lotto.domain;

/**
 * packageName : lotto.domain
 * fileName : RankEnum
 * author : haedoang
 * date : 2021/11/06
 * description :
 */

/**
 * packageName : lotto.domain
 * fileName : Rank_Enum
 * author : haedoang
 * date : 2021/11/06
 * description :
 */
public enum RankEnum {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private int countOfMatch;
    private int winningMoney;

    private RankEnum(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static RankEnum valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
        return countOfMatch == RankEnum.FIRST.getCountOfMatch() ? RankEnum.FIRST
                : countOfMatch == RankEnum.SECOND.getCountOfMatch() && matchBonus ? RankEnum.SECOND
                : countOfMatch == RankEnum.THIRD.getCountOfMatch() && !matchBonus ? RankEnum.THIRD
                : countOfMatch == RankEnum.FOURTH.getCountOfMatch() ? RankEnum.FOURTH
                : countOfMatch == RankEnum.FIFTH.getCountOfMatch()  ? RankEnum.FIFTH : RankEnum.MISS;
    }
}
