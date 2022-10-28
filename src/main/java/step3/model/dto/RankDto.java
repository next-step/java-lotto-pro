package step3.model.dto;


import step3.model.Rank;

public class RankDto {

    private final Rank rank;
    private final int count;

    public RankDto(Rank rank, int count) {
        this.rank = rank;
        this.count = count;
    }

    public boolean isWin() {
        return rank.getMatchCount() >= 3;
    }

    public int getMatchCount() {
        return rank.getMatchCount();
    }

    public int getWinningPrice() {
        return rank.getWinningPrice();
    }

    public int getWinningCount() {
        return count;
    }

}
