package lotto.domain;

public class WinnerIndexHelper {
    private int winnerNumberIndex;
    private int lottoIndex;
    private int rightCount;

    public WinnerIndexHelper() {
        this(0, 0, 0);
    }

    // for test
    public WinnerIndexHelper(int winnerNumberIndex, int lottoIndex, int rightCount) {
        this.winnerNumberIndex = winnerNumberIndex;
        this.lottoIndex = lottoIndex;
        this.rightCount = rightCount;
    }

    public void plus1RightCount() {
        rightCount++;
    }

    public void plus1WinnerNumberIndex() {
        winnerNumberIndex++;
    }

    public void plus1LottoIndex() {
        lottoIndex++;
    }

    public void plus1WinnerNumberIndexAndLottoIndex() {
        plus1LottoIndex();
        plus1WinnerNumberIndex();
    }

    public int getWinnerNumberIndex() {
        return winnerNumberIndex;
    }

    public int getLottoIndex() {
        return lottoIndex;
    }

    public int getRightCount() {
        return rightCount;
    }
}
