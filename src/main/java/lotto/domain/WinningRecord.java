package lotto.domain;

public class WinningRecord {
	private final WinningRank winningRank;
	private final int count;

	private WinningRecord(WinningRank winningRank, int count) {
		this.winningRank = winningRank;
		this.count = count;
	}

	public static WinningRecord of(WinningRank winningRank, int count) {
		return new WinningRecord(winningRank, count);
	}

	public WinningRank getWinningRank() {
		return winningRank;
	}

	public int getCount() {
		return count;
	}
}
