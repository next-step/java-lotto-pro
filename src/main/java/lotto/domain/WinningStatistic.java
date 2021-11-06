package lotto.domain;

public class WinningStatistic {
    private final WinningRank winningRank;
    private final int count;

    public WinningStatistic(WinningRank winningRank, int count) {
        this.winningRank = winningRank;
        this.count = count;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public WinningRank getWinningRank() {
        return this.winningRank;
    }

}
