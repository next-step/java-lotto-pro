package lotto.domain;

public class WinningResult {
    private final WinningRank winningRank;
    private final int count;

    public WinningResult(WinningRank winningRank, int count) {
        this.winningRank = winningRank;
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public WinningRank getWinningRank() {
        return this.winningRank;
    }

    public int getTotalReward() {
        return count * winningRank.getReward();
    }

}
